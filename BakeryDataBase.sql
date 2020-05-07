CREATE TABLE Position (
	Id INTEGER PRIMARY KEY,
	PositionName VARCHAR(30) CHECK(LEN(PositionName) > 1) UNIQUE NOT NULL,
	Salary DECIMAL(8, 2) CHECK(Salary >= 0) NOT NULL
);
CREATE TABLE Account (
	Id INTEGER PRIMARY KEY,
	Account VARCHAR(30) CHECK(LEN(Account) >= 3) UNIQUE NOT NULL,
	Password VARCHAR(100) CHECK(LEN(Password) >= 8) NOT NULL 
);
CREATE TABLE Adres (
	Id INTEGER PRIMARY KEY,
	Street VARCHAR(30) CHECK(LEN(Street) > 1) NULL,
	Nr_Home INTEGER CHECK(Nr_Home > 0) NOT NULL,
	Nr_Apartment INTEGER CHECK(Nr_Apartment > 0) NULL,
	PostalCode CHAR(6) CHECK(PostalCode LIKE '[0-9][0-9]-[0-9][0-9][0-9]') NOT NULL,
	City VARCHAR(30) CHECK(LEN(City) > 1) NOT NULL
);
CREATE TABLE Employee (
	Id INTEGER PRIMARY KEY,
	Id_Adres INTEGER REFERENCES Adres(Id),
	Id_Position INTEGER REFERENCES Position(Id),
	Name VARCHAR(30) CHECK(LEN(Name) > 1) NOT NULL,
	Surname VARCHAR(30) CHECK(LEN(Surname) > 1) NOT NULL,
	Pesel CHAR(11) CHECK(Pesel LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]') NOT NULL,
	BirthDate DATE CHECK(BirthDate <= GETDATE()) NOT NULL,
	Gender CHAR(1) CHECK(Gender = 'w' OR Gender = 'm') NOT NULL,
	PhoneNumber CHAR(9) CHECK(PhoneNumber LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]') NOT NULL,
	Id_Account INTEGER REFERENCES Account(Id),
	ImageURL VARCHAR NULL
);
CREATE TABLE Customer (
	Id INTEGER PRIMARY KEY,
	Id_Adres INTEGER REFERENCES Adres(Id),
	Name VARCHAR(30) CHECK(LEN(Name) > 1) NOT NULL,
	Surname VARCHAR(30) CHECK(LEN(Surname) > 1) NOT NULL,
	Pesel CHAR(11) CHECK(Pesel LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]') NOT NULL,
	ImageURL VARCHAR NULL
);
CREATE TABLE Supplier (
	Id INTEGER PRIMARY KEY,
	Id_Adres INTEGER REFERENCES Adres(Id),
	CompanyName VARCHAR(30) CHECK(LEN(CompanyName) > 1) NOT NULL,
	PhoneNumber CHAR(9) CHECK(PhoneNumber LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]') NOT NULL,
	EMail VARCHAR(30) CHECK(EMail LIKE '%@%.%') NOT NULL
);
CREATE TABLE Subcategory (
	Id INTEGER PRIMARY KEY,
	SubcategoryName VARCHAR(30) CHECK(LEN(SubcategoryName) > 1) UNIQUE NOT NULL,
	ImageURL VARCHAR NULL
);
CREATE TABLE Category (
	Id INTEGER PRIMARY KEY,
	CategoryName VARCHAR(30) CHECK(LEN(CategoryName) > 1) UNIQUE NOT NULL,
	Id_Subccategory INTEGER REFERENCES Subcategory(Id),
	ImageURL VARCHAR NULL
);
CREATE TABLE Product (
	Id INTEGER PRIMARY KEY,
	ProductName VARCHAR(30) CHECK(LEN(ProductName) > 1) UNIQUE NOT NULL,
	Id_Category INTEGER REFERENCES Category(Id),
	Price DECIMAL(8, 2) CHECK(Price >= 0) NOT NULL,
	Amount INTEGER CHECK(Amount >= 0) NOT NULL,
	Desctiprion TEXT,
	Composition TEXT,
	Id_Baker INTEGER REFERENCES Employee(Id),
	Id_Supplier INTEGER REFERENCES Supplier(Id),
	ImageURL VARCHAR NULL
);
CREATE TABLE Packing (
	Id INTEGER PRIMARY KEY,
	PackingType VARCHAR(30) CHECK(LEN(PackingType) > 1) UNIQUE NOT NULL,
	ImageURL VARCHAR NULL
);
CREATE TABLE Payment (
	Id INTEGER PRIMARY KEY,
	PaymentType VARCHAR(30) CHECK(LEN(PaymentType) > 1) UNIQUE NOT NULL,
	ImageURL VARCHAR NULL
);
CREATE TABLE PurchaseOrder (
	Id INTEGER PRIMARY KEY,
	Id_Customer INTEGER REFERENCES Customer(Id),
	Id_Cashier INTEGER REFERENCES Employee(Id),
	Id_PaymentType INTEGER REFERENCES Payment(Id),
	Id_PackingType INTEGER REFERENCES Packing(Id),
	ProductList TEXT NOT NULL,
	OrderTime DATE CHECK(OrderTime <= GETDATE()) NOT NULL,
	OrderCompletion DATE NOT NULL,
	OrderCost DECIMAL(8, 2) CHECK(OrderCost >= 0) NOT NULL,
	OrderCostWithTaxes DECIMAL(8, 2) CHECK(OrderCost >= 0) NOT NULL
);
CREATE TABLE Product_had_PurchaseOrder (
	Id_Product INTEGER REFERENCES Product(Id),
	Id_PurchaseOrder INTEGER REFERENCES PurchaseOrder(Id),
	Amount INTEGER CHECK(Amount > 0) NOT NULL
);