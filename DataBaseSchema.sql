create database WebShopDb
go
use WebShopDb
go

create table Roles(
	Id int primary key identity,
	RoleName nvarchar(40),
)
go

create table Users(
	Id int primary key identity,
	FirstName nvarchar(40),
	LastName nvarchar(40),
	Email nvarchar(40),
	Password nvarchar(100),
	RoleId int foreign key references Roles(Id)
)
go

create table UserRole (
	Email nvarchar(40),
	Role nvarchar(40),
	primary key (Email, Role)
)
go

create trigger UserCreated on Users 
AFTER INSERT
as
begin
   SET NOCOUNT ON;
    INSERT INTO UserRole(
        Email, 
        Role
    )
    SELECT
        i.Email,
		r.RoleName
    FROM
        inserted as i
	inner join Roles as r
	on i.RoleId = r.Id
end
go

create table Category(
	Id int primary key identity not null,
	DisplayName nvarchar(100) not null,
	Link nvarchar(100) not null
)
go

create table Subcategory(
	Id int primary key identity not null,
	DisplayName nvarchar(100) not null,
	Link nvarchar(100) not null,
	CategoryId int foreign key references Category(Id)
)
go

create table Product (
	Id int primary key identity,
	Title nvarchar(100),
	Description nvarchar(MAX),
	ImageName nvarchar(100),
	Price float,
	SubcategoryId int foreign key references Subcategory(Id)
)
go

create table Basket(
	Id int primary key identity,
	Quantity int not null,
	UserId int not null foreign key references Users(Id),
	ProductId int not null foreign key references Product(Id)
)
go

create table PaymentMethod(
	Id int primary key identity,
	TypeName nvarchar(50)
)
go

create table OrderShippingMethod(
	Id int primary key identity,
	Name nvarchar(100)
)
go

create table OrderDeliveryDetails(
	Id int primary key identity,
	StreetAddress nvarchar(100),
	City nvarchar(100),
	Zipcode nvarchar(100),
)
go

create table OrderShippingDetails(
	Id int primary key,
	CollectorFirstName nvarchar(100),
	CollectorLastName nvarchar(100),
	CollectorPhoneNumber nvarchar(100),
	ShippingMethodId int foreign key references OrderShippingMethod(Id)
)
go

create table OrderPickupDetails(
	Id int primary key,
	ShopName nvarchar(100)
)
go

create table Orders (
	Id int primary key identity,
	UserId int foreign key references Users(Id),
	PaymentMethodId int foreign key references PaymentMethod(Id),
	DeliveryDetailsId int foreign key references OrderDeliveryDetails(Id)
)
go

create table OrderProduct(
	Id int primary key identity,
	OrderId int foreign key references Orders(Id),
	Product int foreign key references Product(Id)
)
go