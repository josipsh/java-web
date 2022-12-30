create database WebShopDb
go
use WebShopDb
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
