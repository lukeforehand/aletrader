#import "UPCSearchController.h"
#import "UPCOverlayView.h"
#import "SearchResultController.h"

@interface UPCSearchController ()<AVCaptureMetadataOutputObjectsDelegate>

@property(nonatomic, strong) AVCaptureSession *session;
@property(nonatomic, strong) UIView *previewView;
@property(nonatomic, strong) AVCaptureVideoPreviewLayer *previewLayer;
@property(nonatomic, strong) UPCOverlayView *overlayView;

@end

@implementation UPCSearchController


- (void)viewDidLoad
{
    [super viewDidLoad];
    
    self.session = [[AVCaptureSession alloc] init];
	
	// create the preview layer
	self.previewLayer = [AVCaptureVideoPreviewLayer layerWithSession:self.session];
    self.previewView = [[UIView alloc] init];
    self.previewView.translatesAutoresizingMaskIntoConstraints = NO;
    [self.view addSubview:self.previewView];
    [self.view addConstraints:[NSLayoutConstraint constraintsWithVisualFormat:@"H:|[_previewView]|" options:0 metrics:nil views:NSDictionaryOfVariableBindings(_previewView)]];
    [self.view addConstraints:[NSLayoutConstraint constraintsWithVisualFormat:@"V:|[_previewView]|" options:0 metrics:nil views:NSDictionaryOfVariableBindings(_previewView)]];
    
    self.overlayView = [[UPCOverlayView alloc] init];
    self.overlayView.translatesAutoresizingMaskIntoConstraints = NO;
    [self.view addSubview:self.overlayView];
    [self.view addConstraints:[NSLayoutConstraint constraintsWithVisualFormat:@"H:|[_overlayView]|" options:0 metrics:nil views:NSDictionaryOfVariableBindings(_overlayView)]];
    [self.view addConstraints:[NSLayoutConstraint constraintsWithVisualFormat:@"V:|[_overlayView]|" options:0 metrics:nil views:NSDictionaryOfVariableBindings(_overlayView)]];
    
    [self.previewView.layer addSublayer:self.previewLayer];
    self.previewLayer.videoGravity = AVLayerVideoGravityResize;
    //    previewLayer.orientation = AVCaptureVideoOrientationLandscapeLeft;
	// Get the Camera Device
    NSArray *devices = [AVCaptureDevice devicesWithMediaType:AVMediaTypeVideo];
	AVCaptureDevice *camera = nil; //[AVCaptureDevice defaultDeviceWithMediaType:AVMediaTypeVideo];
    for(camera in devices) {
        if(camera.position == AVCaptureDevicePositionBack) {
            break;
        }
    }
	
	// Create a AVCaptureInput with the camera device
	NSError *error=nil;
	AVCaptureDeviceInput *cameraInput = [[AVCaptureDeviceInput alloc] initWithDevice:camera error:&error];
	if (cameraInput == nil) {
		NSLog(@"Error to create camera capture:%@",error);
	}
 	// Add the input and output
	[self.session addInput:cameraInput];
    
    // Create a VideoDataOutput and add it to the session
    AVCaptureMetadataOutput *output = [[AVCaptureMetadataOutput alloc] init];
    [self.session addOutput:output];
    
    // see what types are supported (do this after adding otherwise the output reports nothing supported
    NSSet *potentialDataTypes = [NSSet setWithArray:@[AVMetadataObjectTypeAztecCode,
                                                      AVMetadataObjectTypeCode128Code,
                                                      AVMetadataObjectTypeCode39Code,
                                                      AVMetadataObjectTypeCode39Mod43Code,
                                                      AVMetadataObjectTypeCode93Code,
                                                      AVMetadataObjectTypeEAN13Code,
                                                      AVMetadataObjectTypeEAN8Code,
                                                      AVMetadataObjectTypePDF417Code,
                                                      AVMetadataObjectTypeQRCode,
                                                      AVMetadataObjectTypeUPCECode]];
    
    NSMutableArray *supportedMetaDataTypes = [NSMutableArray array];
    for(NSString *availableMetadataObject in output.availableMetadataObjectTypes) {
        if([potentialDataTypes containsObject:availableMetadataObject]) {
            [supportedMetaDataTypes addObject:availableMetadataObject];
        }
    }
    
    [output setMetadataObjectTypes:supportedMetaDataTypes];
    
    // Get called back everytime something is recognised
    [output setMetadataObjectsDelegate:self queue:dispatch_get_main_queue()];
	
	// Start the session running
	[self.session startRunning];
}

- (void)captureOutput:(AVCaptureOutput *)captureOutput didOutputMetadataObjects:(NSArray *)metadataObjects fromConnection:(AVCaptureConnection *)connection {
    // draw where the recognised data is - for 1D barcodes this turns out to be just a line accross the code. For 2D barcodes it's a bit more interesting
    CGMutablePathRef pathRef = CGPathCreateMutable();
    CGAffineTransform transform = CGAffineTransformMakeScale(self.overlayView.bounds.size.width, self.overlayView.bounds.size.height);
    
    for(AVMetadataMachineReadableCodeObject *recognizedObject in metadataObjects) {
        NSLog(@"%@", recognizedObject.stringValue);
        
        _upcCodeText = recognizedObject.stringValue;
        
        CGPoint p1 = CGPointMake(0.4, 0.4);
        CGPointMakeWithDictionaryRepresentation((__bridge CFDictionaryRef)(recognizedObject.corners[0]), &p1);
        CGPoint p2 = CGPointMake(0.5, 0.4);
        CGPointMakeWithDictionaryRepresentation((__bridge CFDictionaryRef)(recognizedObject.corners[1]), &p2);
        CGPoint p3 = CGPointMake(0.5, 0.5);
        CGPointMakeWithDictionaryRepresentation((__bridge CFDictionaryRef)(recognizedObject.corners[2]), &p3);
        CGPoint p4 = CGPointMake(0.4, 0.5);
        CGPointMakeWithDictionaryRepresentation((__bridge CFDictionaryRef)(recognizedObject.corners[3]), &p4);
        
        CGPathMoveToPoint(pathRef, &transform, 1-p1.y, p1.x);
        CGPathAddLineToPoint(pathRef, &transform, 1-p2.y, p2.x);
        CGPathAddLineToPoint(pathRef, &transform, 1-p3.y, p3.x);
        CGPathAddLineToPoint(pathRef, &transform, 1-p4.y, p4.x);
        
        CGPathCloseSubpath(pathRef);
        
    }
    ((CAShapeLayer *) self.overlayView.layer).path = pathRef;
    CGPathRelease(pathRef);
    
    [self.session stopRunning];
    
    [self performSegueWithIdentifier: @"SearchResult" sender: self];
    
}

-(void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    
    NSLog(@"prepareForSegue: %@", segue.identifier);
    if([segue.identifier isEqualToString:@"SearchResult"]) {
        SearchResultController *transferViewController = segue.destinationViewController;
        transferViewController.upcCodeText = _upcCodeText;
    }

}

-(void) viewDidLayoutSubviews {
    [super viewDidLayoutSubviews];
    self.previewLayer.frame = self.previewView.bounds;
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


@end
