CREATE TABLE `users` (                    
          `id` int(11) NOT NULL,                  
          `user_login` varchar(50) DEFAULT NULL,  
          `user_pass` varchar(50) DEFAULT NULL,   
          `age` int(11) DEFAULT NULL,             
          PRIMARY KEY (`id`)                      
        );