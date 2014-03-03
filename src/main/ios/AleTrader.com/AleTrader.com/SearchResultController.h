//
//  SearchResultController.h
//  AleTrader.com
//
//  Created by Lindsay Berger on 3/2/14.
//  Copyright (c) 2014 Luke Forehand. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface SearchResultController : UIViewController

@property (strong, nonatomic) IBOutlet UILabel *upcCode;
@property (strong, nonatomic)          NSString *upcCodeText;

@property (strong, nonatomic) IBOutlet UILabel *searchResult;

@end

