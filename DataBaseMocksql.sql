use WebShopDb
go

insert Category ([DisplayName], [Link]) values ('Eletronic', 'eletronic') -- id 1
insert Category ([DisplayName], [Link]) values ('Audio / video', 'audio_video') -- id 2
go

insert Subcategory ([DisplayName], [Link], [CategoryId]) values ('Prebuild computers', 'prebuild_computers', 1)		-- id 1
insert Subcategory ([DisplayName], [Link], [CategoryId]) values ('Computers components', 'computers_components', 1)	-- id 2
insert Subcategory ([DisplayName], [Link], [CategoryId]) values ('Sreens', 'screens', 1)							-- id 3
insert Subcategory ([DisplayName], [Link], [CategoryId]) values ('Storage', 'storage', 1)							-- id 4
insert Subcategory ([DisplayName], [Link], [CategoryId]) values ('Microfons', 'microfons', 2)						-- id 5
insert Subcategory ([DisplayName], [Link], [CategoryId]) values ('Dslr', 'dslr', 2)									-- id 6
insert Subcategory ([DisplayName], [Link], [CategoryId]) values ('Mirrorless cameras', 'mirrorless_cameras', 2)		-- id 7
insert Subcategory ([DisplayName], [Link], [CategoryId]) values ('Analog cameras', 'analog_cameras', 2)				-- id 8
go

insert Product ([Title], [Description], [ImageName], [Price], [SubcategoryId]) values ('Title1', 'Description 1 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam libero diam, pellentesque sed vehicula in, laoreet nec sapien. Curabitur dapibus mauris libero, sed facilisis purus aliquet condimentum. Integer ultrices metus venenatis, interdum enim id, ultricies magna. Nunc enim leo, tristique sit amet nulla et, facilisis molestie ex. Pellentesque sollicitudin enim sed mi malesuada dapibus. Duis nec urna faucibus nulla elementum gravida non sit amet nunc. Nam varius quam eget quam luctus lobortis.', 'products/IMG_8221.JPG', 15.99, 1)
insert Product ([Title], [Description], [ImageName], [Price], [SubcategoryId]) values ('Title2', 'Description 2 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam libero diam, pellentesque sed vehicula in, laoreet nec sapien. Curabitur dapibus mauris libero, sed facilisis purus aliquet condimentum. Integer ultrices metus venenatis, interdum enim id, ultricies magna. Nunc enim leo, tristique sit amet nulla et, facilisis molestie ex. Pellentesque sollicitudin enim sed mi malesuada dapibus. Duis nec urna faucibus nulla elementum gravida non sit amet nunc. Nam varius quam eget quam luctus lobortis.', 'products/IMG_8206.JPG', 15.99, 1)
insert Product ([Title], [Description], [ImageName], [Price], [SubcategoryId]) values ('Title3', 'Description 3 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam libero diam, pellentesque sed vehicula in, laoreet nec sapien. Curabitur dapibus mauris libero, sed facilisis purus aliquet condimentum. Integer ultrices metus venenatis, interdum enim id, ultricies magna. Nunc enim leo, tristique sit amet nulla et, facilisis molestie ex. Pellentesque sollicitudin enim sed mi malesuada dapibus. Duis nec urna faucibus nulla elementum gravida non sit amet nunc. Nam varius quam eget quam luctus lobortis.', 'products/IMG_8202.JPG', 15.99, 2)
insert Product ([Title], [Description], [ImageName], [Price], [SubcategoryId]) values ('Title4', 'Description 4 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam libero diam, pellentesque sed vehicula in, laoreet nec sapien. Curabitur dapibus mauris libero, sed facilisis purus aliquet condimentum. Integer ultrices metus venenatis, interdum enim id, ultricies magna. Nunc enim leo, tristique sit amet nulla et, facilisis molestie ex. Pellentesque sollicitudin enim sed mi malesuada dapibus. Duis nec urna faucibus nulla elementum gravida non sit amet nunc. Nam varius quam eget quam luctus lobortis.', 'products/IMG_8201.JPG', 15.99, 2)
insert Product ([Title], [Description], [ImageName], [Price], [SubcategoryId]) values ('Title4', 'Description 5 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam libero diam, pellentesque sed vehicula in, laoreet nec sapien. Curabitur dapibus mauris libero, sed facilisis purus aliquet condimentum. Integer ultrices metus venenatis, interdum enim id, ultricies magna. Nunc enim leo, tristique sit amet nulla et, facilisis molestie ex. Pellentesque sollicitudin enim sed mi malesuada dapibus. Duis nec urna faucibus nulla elementum gravida non sit amet nunc. Nam varius quam eget quam luctus lobortis.', 'products/IMG_8221.JPG', 15.99, 3)
insert Product ([Title], [Description], [ImageName], [Price], [SubcategoryId]) values ('Title5', 'Description 6 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam libero diam, pellentesque sed vehicula in, laoreet nec sapien. Curabitur dapibus mauris libero, sed facilisis purus aliquet condimentum. Integer ultrices metus venenatis, interdum enim id, ultricies magna. Nunc enim leo, tristique sit amet nulla et, facilisis molestie ex. Pellentesque sollicitudin enim sed mi malesuada dapibus. Duis nec urna faucibus nulla elementum gravida non sit amet nunc. Nam varius quam eget quam luctus lobortis.', 'products/IMG_8206.JPG', 15.99, 3)
insert Product ([Title], [Description], [ImageName], [Price], [SubcategoryId]) values ('Title6', 'Description 7 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam libero diam, pellentesque sed vehicula in, laoreet nec sapien. Curabitur dapibus mauris libero, sed facilisis purus aliquet condimentum. Integer ultrices metus venenatis, interdum enim id, ultricies magna. Nunc enim leo, tristique sit amet nulla et, facilisis molestie ex. Pellentesque sollicitudin enim sed mi malesuada dapibus. Duis nec urna faucibus nulla elementum gravida non sit amet nunc. Nam varius quam eget quam luctus lobortis.', 'products/IMG_8202.JPG', 15.99, 4)
insert Product ([Title], [Description], [ImageName], [Price], [SubcategoryId]) values ('Title7', 'Description 8 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam libero diam, pellentesque sed vehicula in, laoreet nec sapien. Curabitur dapibus mauris libero, sed facilisis purus aliquet condimentum. Integer ultrices metus venenatis, interdum enim id, ultricies magna. Nunc enim leo, tristique sit amet nulla et, facilisis molestie ex. Pellentesque sollicitudin enim sed mi malesuada dapibus. Duis nec urna faucibus nulla elementum gravida non sit amet nunc. Nam varius quam eget quam luctus lobortis.', 'products/IMG_8201.JPG', 15.99, 4)
insert Product ([Title], [Description], [ImageName], [Price], [SubcategoryId]) values ('Title8', 'Description 9 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam libero diam, pellentesque sed vehicula in, laoreet nec sapien. Curabitur dapibus mauris libero, sed facilisis purus aliquet condimentum. Integer ultrices metus venenatis, interdum enim id, ultricies magna. Nunc enim leo, tristique sit amet nulla et, facilisis molestie ex. Pellentesque sollicitudin enim sed mi malesuada dapibus. Duis nec urna faucibus nulla elementum gravida non sit amet nunc. Nam varius quam eget quam luctus lobortis.', 'products/IMG_8221.JPG', 15.99, 5)
insert Product ([Title], [Description], [ImageName], [Price], [SubcategoryId]) values ('Title9', 'Description 10 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam libero diam, pellentesque sed vehicula in, laoreet nec sapien. Curabitur dapibus mauris libero, sed facilisis purus aliquet condimentum. Integer ultrices metus venenatis, interdum enim id, ultricies magna. Nunc enim leo, tristique sit amet nulla et, facilisis molestie ex. Pellentesque sollicitudin enim sed mi malesuada dapibus. Duis nec urna faucibus nulla elementum gravida non sit amet nunc. Nam varius quam eget quam luctus lobortis.', 'products/IMG_8206.JPG', 15.99, 5)
insert Product ([Title], [Description], [ImageName], [Price], [SubcategoryId]) values ('Title10', 'Description 11 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam libero diam, pellentesque sed vehicula in, laoreet nec sapien. Curabitur dapibus mauris libero, sed facilisis purus aliquet condimentum. Integer ultrices metus venenatis, interdum enim id, ultricies magna. Nunc enim leo, tristique sit amet nulla et, facilisis molestie ex. Pellentesque sollicitudin enim sed mi malesuada dapibus. Duis nec urna faucibus nulla elementum gravida non sit amet nunc. Nam varius quam eget quam luctus lobortis.', 'products/IMG_8202.JPG', 15.99, 6)
insert Product ([Title], [Description], [ImageName], [Price], [SubcategoryId]) values ('Title11', 'Description 12 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam libero diam, pellentesque sed vehicula in, laoreet nec sapien. Curabitur dapibus mauris libero, sed facilisis purus aliquet condimentum. Integer ultrices metus venenatis, interdum enim id, ultricies magna. Nunc enim leo, tristique sit amet nulla et, facilisis molestie ex. Pellentesque sollicitudin enim sed mi malesuada dapibus. Duis nec urna faucibus nulla elementum gravida non sit amet nunc. Nam varius quam eget quam luctus lobortis.', 'products/IMG_8201.JPG', 15.99, 6)
insert Product ([Title], [Description], [ImageName], [Price], [SubcategoryId]) values ('Title12', 'Description 13 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam libero diam, pellentesque sed vehicula in, laoreet nec sapien. Curabitur dapibus mauris libero, sed facilisis purus aliquet condimentum. Integer ultrices metus venenatis, interdum enim id, ultricies magna. Nunc enim leo, tristique sit amet nulla et, facilisis molestie ex. Pellentesque sollicitudin enim sed mi malesuada dapibus. Duis nec urna faucibus nulla elementum gravida non sit amet nunc. Nam varius quam eget quam luctus lobortis.', 'products/IMG_8221.JPG', 15.99, 7)
insert Product ([Title], [Description], [ImageName], [Price], [SubcategoryId]) values ('Title13', 'Description 14 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam libero diam, pellentesque sed vehicula in, laoreet nec sapien. Curabitur dapibus mauris libero, sed facilisis purus aliquet condimentum. Integer ultrices metus venenatis, interdum enim id, ultricies magna. Nunc enim leo, tristique sit amet nulla et, facilisis molestie ex. Pellentesque sollicitudin enim sed mi malesuada dapibus. Duis nec urna faucibus nulla elementum gravida non sit amet nunc. Nam varius quam eget quam luctus lobortis.', 'products/IMG_8206.JPG', 15.99, 7)
insert Product ([Title], [Description], [ImageName], [Price], [SubcategoryId]) values ('Title14', 'Description 15 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam libero diam, pellentesque sed vehicula in, laoreet nec sapien. Curabitur dapibus mauris libero, sed facilisis purus aliquet condimentum. Integer ultrices metus venenatis, interdum enim id, ultricies magna. Nunc enim leo, tristique sit amet nulla et, facilisis molestie ex. Pellentesque sollicitudin enim sed mi malesuada dapibus. Duis nec urna faucibus nulla elementum gravida non sit amet nunc. Nam varius quam eget quam luctus lobortis.', 'products/IMG_8202.JPG', 15.99, 8)
insert Product ([Title], [Description], [ImageName], [Price], [SubcategoryId]) values ('Title15', 'Description 16 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam libero diam, pellentesque sed vehicula in, laoreet nec sapien. Curabitur dapibus mauris libero, sed facilisis purus aliquet condimentum. Integer ultrices metus venenatis, interdum enim id, ultricies magna. Nunc enim leo, tristique sit amet nulla et, facilisis molestie ex. Pellentesque sollicitudin enim sed mi malesuada dapibus. Duis nec urna faucibus nulla elementum gravida non sit amet nunc. Nam varius quam eget quam luctus lobortis.', 'products/IMG_8201.JPG', 15.99, 8)
go

insert Roles ([RoleName]) values ('CUSTOMER')
insert Roles ([RoleName]) values ('ADMIN')
go

insert Users ([FirstName], [LastName], [Email], [Password], [RoleId]) values ('Pero', 'Peric', 'pero.peric@gmail.com', 'test123', 2)
insert Users ([FirstName], [LastName], [Email], [Password], [RoleId]) values ('Ivan', 'Ivic', 'ivan.ivic@gmail.com', 'test123', 1)
insert Users ([FirstName], [LastName], [Email], [Password], [RoleId]) values ('Iva', 'Ivic', 'iva.ivic@gmail.com', 'test123', 1)
insert Users ([FirstName], [LastName], [Email], [Password], [RoleId]) values ('Lea', 'Leic', 'lea.leic@gmail.com', 'test123', 1)
go

insert PaymentMethod ([TypeName]) values ('Cash')		-- id 1
insert PaymentMethod ([TypeName]) values ('PayPal')		-- id 2
go

insert Basket ([Quantity], [UserId], [ProductId]) values (1, 2, 1)
insert Basket ([Quantity], [UserId], [ProductId]) values (2, 2, 2)
insert Basket ([Quantity], [UserId], [ProductId]) values (3, 2, 3)
insert Basket ([Quantity], [UserId], [ProductId]) values (1, 3, 4)
insert Basket ([Quantity], [UserId], [ProductId]) values (1, 3, 5)
insert Basket ([Quantity], [UserId], [ProductId]) values (5, 3, 6)
insert Basket ([Quantity], [UserId], [ProductId]) values (1, 4, 7)
insert Basket ([Quantity], [UserId], [ProductId]) values (2, 4, 8)
insert Basket ([Quantity], [UserId], [ProductId]) values (1, 4, 9)
go

insert OrderShippingMethod ([Name]) values ('GSL')			-- id 1
insert OrderShippingMethod ([Name]) values ('Overseass')	-- id 2
go

insert OrderDeliveryDetails ([StreetAddress], [City], [Zipcode]) values ('Strojarska 22', 'Zagreb', '10 000')		-- id 1
insert OrderDeliveryDetails ([StreetAddress], [City], [Zipcode]) values ('Glavna ulica 3', 'Varazdin', '42 000')	-- id 2
insert OrderDeliveryDetails ([StreetAddress], [City], [Zipcode]) values ('Ilica 44', 'Zagreb', '10 000')			-- id 3
insert OrderDeliveryDetails ([StreetAddress], [City], [Zipcode]) values ('Ilica 256', 'Zagreb', '10 000')			-- id 4
go

insert OrderPickupDetails ([Id], [ShopName]) values (1, 'Trgovina Zagreb')
insert OrderPickupDetails ([Id], [ShopName]) values (2, 'TrgoviNA Varazdin')

insert OrderShippingDetails ([Id], [CollectorFirstName], [CollectorLastName], [CollectorPhoneNumber], [ShippingMethodId]) values (3, 'Marko', 'Maric', '091 8524 452', 1)
insert OrderShippingDetails ([Id], [CollectorFirstName], [CollectorLastName], [CollectorPhoneNumber], [ShippingMethodId]) values (4, 'Ivko', 'Ivanic', '098 1256 789', 2)
go

insert Orders ([UserId], [PaymentMethodId], [DeliveryDetailsId]) values (2, 1, 1)	-- id 1
insert Orders ([UserId], [PaymentMethodId], [DeliveryDetailsId]) values (2, 2, 2)	-- id 2
insert Orders ([UserId], [PaymentMethodId], [DeliveryDetailsId]) values (3, 2, 3)	-- id 3
insert Orders ([UserId], [PaymentMethodId], [DeliveryDetailsId]) values (4, 1, 4)	-- id 4
go

insert OrderProduct ([OrderId], [ProductId]) values (1, 1)
insert OrderProduct ([OrderId], [ProductId]) values (1, 2)
insert OrderProduct ([OrderId], [ProductId]) values (1, 3)
insert OrderProduct ([OrderId], [ProductId]) values (1, 4)
insert OrderProduct ([OrderId], [ProductId]) values (1, 10)
insert OrderProduct ([OrderId], [ProductId]) values (1, 15)

insert OrderProduct ([OrderId], [ProductId]) values (2, 5)
insert OrderProduct ([OrderId], [ProductId]) values (2, 6)
insert OrderProduct ([OrderId], [ProductId]) values (2, 7)
insert OrderProduct ([OrderId], [ProductId]) values (2, 1)
insert OrderProduct ([OrderId], [ProductId]) values (2, 10)
insert OrderProduct ([OrderId], [ProductId]) values (2, 16)

insert OrderProduct ([OrderId], [ProductId]) values (3, 9)
insert OrderProduct ([OrderId], [ProductId]) values (3, 10)
insert OrderProduct ([OrderId], [ProductId]) values (3, 11)
insert OrderProduct ([OrderId], [ProductId]) values (3, 12)

insert OrderProduct ([OrderId], [ProductId]) values (4, 13)
insert OrderProduct ([OrderId], [ProductId]) values (4, 14)
insert OrderProduct ([OrderId], [ProductId]) values (4, 15)
insert OrderProduct ([OrderId], [ProductId]) values (4, 16)
go

insert LoginRecordHistory ([IpAddress], [LoggedInAt], [UserId]) values ('192.168.5.4', '2022-11-09 15:45:21', 2)
insert LoginRecordHistory ([IpAddress], [LoggedInAt], [UserId]) values ('192.168.10.40', '2022-11-01 15:45:21', 2)
insert LoginRecordHistory ([IpAddress], [LoggedInAt], [UserId]) values ('192.168.50.44', '2022-11-10 14:45:21', 3)
insert LoginRecordHistory ([IpAddress], [LoggedInAt], [UserId]) values ('192.168.15.45', '2022-11-15 18:45:21', 3)
insert LoginRecordHistory ([IpAddress], [LoggedInAt], [UserId]) values ('192.168.45.45', '2022-11-25 11:45:21', 4)
insert LoginRecordHistory ([IpAddress], [LoggedInAt], [UserId]) values ('192.168.96.42', '2022-11-15 19:45:21', 4)