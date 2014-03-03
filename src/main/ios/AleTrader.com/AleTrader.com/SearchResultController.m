//
//  SearchResultController.m
//  AleTrader.com
//
//  Created by Lindsay Berger on 3/2/14.
//  Copyright (c) 2014 Luke Forehand. All rights reserved.
//

#import "SearchResultController.h"

#define aletraderApiUrl @"http://aletrader.com/api/upc/"

@interface SearchResultController ()

@end


@implementation SearchResultController

- (void)viewDidLoad
{
    [super viewDidLoad];
    
    self.searchResult.text = @"";
    
    // upc label
    self.upcCode.text = _upcCodeText;
    NSLog(@"upcCode:%@", _upcCodeText);
    
    // upc search result
    NSDictionary* json = [self searchUpc: _upcCodeText];
    
    // beer results label
    NSArray* beers = json[@"data"];
    for (id beer in beers) {
        self.searchResult.text = [[self.searchResult.text stringByAppendingString: beer[@"name"]] stringByAppendingString: @"\n"];
    }
    
}

- (NSDictionary *)searchUpc:(NSString *)upcCode {
    NSURL* url = [NSURL URLWithString:[aletraderApiUrl stringByAppendingString: upcCode]];
    NSLog(@"url:%@", url);
    
    NSData* data = [NSData dataWithContentsOfURL: url];
    NSError* error;
    return [NSJSONSerialization
                          JSONObjectWithData:data
                          options:kNilOptions
                          error:&error];
    
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
