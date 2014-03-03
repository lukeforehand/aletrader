//
//  SearchResultController.m
//  AleTrader.com
//
//  Created by Lindsay Berger on 3/2/14.
//  Copyright (c) 2014 Luke Forehand. All rights reserved.
//

#import "SearchResultController.h"

@interface SearchResultController ()

@end

@implementation SearchResultController

- (void)viewDidLoad
{
    [super viewDidLoad];
    self.upcCode.text = _upcCodeText;
    NSLog(@"upcCode:%@", _upcCodeText);
    
    
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
