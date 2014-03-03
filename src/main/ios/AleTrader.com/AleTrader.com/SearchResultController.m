//
//  SearchResultController.m
//  AleTrader.com
//
//  Created by Lindsay Berger on 3/2/14.
//  Copyright (c) 2014 Luke Forehand. All rights reserved.
//

#import "SearchResultController.h"

#define aletraderApiUrl @"http://aletrader.com/upc/"

@interface SearchResultController ()

@end


@implementation SearchResultController

- (void)viewDidLoad
{
    [super viewDidLoad];
    self.upcCode.text = _upcCodeText;
    NSLog(@"upcCode:%@", _upcCodeText);
    
    dispatch_async(dispatch_get_global_queue(DISPATCH_QUEUE_PRIORITY_DEFAULT, 0), ^{
        NSData* data = [NSData dataWithContentsOfURL: [NSURL URLWithString:[aletraderApiUrl stringByAppendingString: _upcCodeText]]];
        [self performSelectorOnMainThread:@selector(searchUpc:) withObject:data waitUntilDone:YES];
    });
    
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (void)searchUpc:(NSData *)responseData {
    NSError* error;
    NSDictionary* json = [NSJSONSerialization
                          JSONObjectWithData:responseData
                          options:kNilOptions
                          error:&error];
    
    NSLog(@"result: %@", json);
    
    self.searchResult.text = json.description;
    
}

@end
