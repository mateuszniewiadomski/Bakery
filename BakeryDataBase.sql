/*

		Drops all tables	

*/

DROP TABLE IF EXISTS Product_had_PurchaseOrder
DROP TABLE IF EXISTS PurchaseOrder
DROP TABLE IF EXISTS Payment
DROP TABLE IF EXISTS Packing
DROP TABLE IF EXISTS Product
DROP TABLE IF EXISTS Category
DROP TABLE IF EXISTS Subcategory
DROP TABLE IF EXISTS Supplier
DROP TABLE IF EXISTS Customer
DROP TABLE IF EXISTS Employee
DROP TABLE IF EXISTS Adres
DROP TABLE IF EXISTS Account
DROP TABLE IF EXISTS Position

/*

		Craetes Data Base	

*/

CREATE TABLE Position (
	Id INTEGER PRIMARY KEY,
	PositionName VARCHAR(30) CHECK(LEN(PositionName) > 1) UNIQUE NOT NULL,
	Salary DECIMAL(8, 2) CHECK(Salary >= 0) NOT NULL
);
CREATE TABLE Account (
	Id INTEGER PRIMARY KEY,
	Account VARCHAR(30) CHECK(LEN(Account) >= 3) UNIQUE NOT NULL,
	Password VARCHAR(104) NOT NULL 
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
	ProductName VARCHAR(50) CHECK(LEN(ProductName) > 1) UNIQUE NOT NULL,
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
	OrderCostWithTaxes DECIMAL(8, 2) CHECK(OrderCostWithTaxes >= 0) NOT NULL
);
CREATE TABLE Product_had_PurchaseOrder (
	Id_Product INTEGER REFERENCES Product(Id),
	Id_PurchaseOrder INTEGER REFERENCES PurchaseOrder(Id),
	Amount INTEGER CHECK(Amount > 0) NOT NULL
);

/*	

		Inserts some stuff at start		

*/

INSERT INTO Position VALUES 
(1, 'Manager', 6000),
(2, 'Confectioner', 4500),
(3, 'Seller', 3500),
(4, 'Cleaner', 3000);

	
	--Passwords are same as account names

INSERT INTO Account VALUES
(1, 'admin', '744D55E32BA65F3DDDB73C1097911A9FDD879A4689C2140282EA273C5B6A0C59AC91DC13B7043D5695448557BC9269DB2F8DBDB8'),
(2, 'seller', '070C1E562D06DD95B4C9515F60409DC3295125CFB11A41FA7D4D2CB4F7DF0D66C393872B8532B41D99B263186E297D4C1F33B42E'),
(3, 'seller2', '7A9CB806A2B66FD1383EF348E78538E66E31908E788E58A94134D52A3FD3685BFB35E75618715BDE36DF31C96ED8A905EB3DA8F6');

INSERT INTO Adres VALUES
(1, 'Warzywnicza', 61, NULL, '80-838', 'Gdansk'),
(2, 'Promowa', 102, NULL, '80-702', 'Gdansk'),
(3, 'Sniezna', 105, NULL, '80-554', 'Gdansk'),
(4, 'Doki', 62, NULL, '80-863', 'Gdansk'),
(5, 'Zwyciestwa', 21, NULL, '80-210', 'Gdansk'),
(6, 'Sienna', 92, NULL, '80-605', 'Gdansk'),
(7, 'Jelenigorska', 63, NULL, '80-180', 'Gdansk'),
(8, 'Maszynowa', 105, NULL, '80-298', 'Gdansk'),
(9, 'Zamiejska', 110, NULL, '80-036', 'Gdansk'),
(10, 'Swojska', 64, NULL, '80-605', 'Gdansk'),
(11, 'Jelenigorska', 66, NULL, '80-180', 'Gdansk'),
(12, 'Sniezna', 15, NULL, '80-554', 'Gdansk');

INSERT INTO Employee VALUES
(1, 1, 1, 'Grzegorz', 'Gorski', '93121235950', '1993-12-12', 'm', '192372881', 1, NULL),
(2, 2, 2, 'Tadeusz', 'Adamczyk', '92072568650', '1992-07-25', 'm', '167220048', NULL, NULL),
(3, 3, 2, 'Cibor', 'Duda', '69101154555', '1969-10-11', 'm', '983224928', NULL, NULL),
(4, 4, 3, 'Kornelia', 'Krol', '56091054387', '1956-09-10', 'w', '898036325', 2, NULL),
(5, 5, 3, 'Przemyslaw', 'Jablonski', '59070630198', '1959-07-06', 'm', '261094108', 3, NULL),
(6, 6, 4, 'Franciszka', 'Wozniak', '73041706842', '1973-04-17', 'w', '387600103', NULL, NULL);

INSERT INTO Customer VALUES
(1, 11, 'Patryk', 'Jaworski', NULL),
(2, 12, 'Milosz', 'Kowalski', NULL);

INSERT INTO Supplier VALUES 
(1, 7, 'HotCoffe', '919823456', 'contact@hotcoffe.com'),
(2, 8, 'WetDrink', '085195505', 'contact@wetdrink.com'),
(3, 9, 'SweetIceCrems', '982753774', 'contact@sweeticecreams.com'),
(4, 10, 'BestJam', '742724069', 'contact@bestjam.com');

INSERT INTO Subcategory VALUES
(1, 'Cakes', NULL),
(2, 'Dessert cakes', NULL),
(3, 'Baked cakes', NULL),
(4, 'Cookies', NULL),
(5, 'Ice cream', NULL),
(6, 'Bevarages', NULL),
(7, 'Fruit preserves', NULL),
(8, 'Bread', NULL);

INSERT INTO Category VALUES
(1, 'Children cake', 1, NULL),
(2, 'Wedding cake', 1, NULL),
(3, 'First Communion cake', 1, NULL),
(4, 'Christening cake', 1, NULL),
(5, 'Normal cake', 1, NULL),
(6, 'Slices', 2, NULL),
(7, 'Roulades', 2, NULL),
(8, 'Dessert tarts', 2, NULL),
(9, 'Bundt cakes', 3, NULL),
(10, 'Cheesecakes', 3, NULL),
(11, 'Apple pies', 3, NULL),
(12, 'Pies', 3, NULL),
(13, 'Baked tarts', 3, NULL),
(14, 'Cupcakes', 4, NULL),
(15, 'Banquet cookies', 4, NULL),
(16, 'Single cookies', 4, NULL),
(17, 'Desserts', 5, NULL),
(18, 'Scoop Ice Cream', 5, NULL),
(19, 'Coffes', 6, NULL),
(20, 'Teas', 6, NULL),
(21, 'Chocolates', 6, NULL),
(22, 'Cold Drinks', 6, NULL),
(23, 'Sweet preserves', 7, NULL),
(24, 'Sour preserves', 7, NULL),
(25, 'Bread', 8, NULL),
(26, 'Bread rolls', 8, NULL);

INSERT INTO Product VALUES
(1, 'Peppa Pig', 1, 50, 0, 'Peppa Pig Cake', '100% love', 2, NULL, NULL),
(2, 'Crying Smiling Emoji', 1, 10, 0, 'Crying Smiling Emoji Cake', '100% Pane', 2, NULL, NULL),
(3, 'Angel White', 2, 100, 0, 'Angel White', 'The whitest cake!', 2, NULL, NULL),
(4, 'Love Chocolate', 2, 150, 0, 'Best Wedding Cake', 'White and dark chocolate', 2, NULL, NULL),
(5, 'Holy Bible', 3, 50, 0, 'Looks like real book!', NULL, 2, NULL, NULL),
(6, 'Cake with Hoste', 3, 60, 0, NULL, NULL, 2, NULL, NULL),
(7, 'Little Baby White', 4, 25, 0, NULL, NULL, 2, NULL, NULL),
(8, 'Little Baby Blue', 4, 25, 0, NULL, NULL, 2, NULL, NULL),
(9, 'Raspberry Cake', 5, 20, 10, NULL, NULL, 2, NULL, NULL),
(10, 'Blueberry Cake', 5, 20, 10, NULL, NULL, 2, NULL, NULL),
(11, 'Lemon Cake', 5, 20, 10, NULL, NULL, 2, NULL, NULL),
(12, 'Black Currant', 6, 10, 30, NULL, NULL, 2, NULL, NULL),
(13, 'Peach Cheesecake', 6, 7, 30, NULL, NULL, 2, NULL, NULL),
(14, 'Rool Beige', 7, 20, 30, NULL, NULL, 2, NULL, NULL),
(15, 'Big Mix', 8, 20, 0, NULL, NULL, 3, NULL, NULL),
(16, 'Small Mix', 8, 30, 0, NULL, NULL, 3, NULL, NULL),
(17, 'Chocolate cake', 9, 50, 30, NULL, NULL, 2, NULL, NULL),
(18, 'Brioche', 9, 20, 30, NULL, NULL, 2, NULL, NULL),
(19, 'Traditional Cheesecake', 10, 20, 30, NULL, NULL, 2, NULL, NULL),
(20, 'Home Cheesecake', 10, 20, 30, NULL, NULL, 2, NULL, NULL),
(21, 'Crispy Cheesecake', 10, 20, 30, NULL, NULL, 2, NULL, NULL),
(22, 'Dessert Apple Pie', 11, 20, 30, NULL, NULL, 2, NULL, NULL),
(23, 'Traditional Apple Pie', 11, 20, 30, NULL, NULL, 2, NULL, NULL),
(24, 'Poppy Seed Cake', 12, 20, 30, NULL, NULL, 2, NULL, NULL),
(25, 'Yogurt Cake With Rhubarb', 12, 20, 30, NULL, NULL, 2, NULL, NULL),
(26, 'Gooseberry Tart', 13, 20, 30, NULL, NULL, 2, NULL, NULL),
(27, 'Cheese Tart', 13, 20, 30, NULL, NULL, 2, NULL, NULL),
(28, 'Chocolate Cookies', 16, 20, 30, NULL, NULL, 2, NULL, NULL),
(29, 'Oatmeal Cookies', 16, 20, 30, NULL, NULL, 2, NULL, NULL),
(30, 'Cupcakes With Chocolate', 14, 20, 30, NULL, NULL, 2, NULL, NULL),
(31, 'Cupcakes With Vanilla', 14, 20, 30, NULL, NULL, 2, NULL, NULL),
(32, 'Apple Cake Big', 15, 20, 30, NULL, NULL, 2, NULL, NULL),
(33, 'Apple Cake Small', 15, 20, 30, NULL, NULL, 2, NULL, NULL),
(34, 'Mini Dessert Mango', 15, 20, 30, NULL, NULL, 3, NULL, NULL),
(35, 'Mini Dessert Panna Cotta', 15, 20, 30, NULL, NULL, 3, NULL, NULL),
(36, 'Raspberry Bliss', 17, 20, 30, NULL, NULL, 3, 3, NULL),
(37, 'Chocolate Temptation', 17, 20, 30, NULL, NULL, 3, 3, NULL),
(38, 'Chocolate', 18, 20, 100, NULL, NULL, 3, 3, NULL),
(39, 'Vanilla', 18, 20, 100, NULL, NULL, 3, 3, NULL),
(40, 'Salty Caramel', 18, 20, 100, NULL, NULL, 3, 3, NULL),
(41, 'Creamy', 18, 20, 100, NULL, NULL, 2, 3, NULL),
(42, 'Espresso', 19, 20, 1000, NULL, NULL, NULL, 1, NULL),
(43, 'Cappuciono', 19, 20, 1000, NULL, NULL, NULL, 1, NULL),
(44, 'Late Macchiato', 19, 20, 1000, NULL, NULL, NULL, 1, NULL),
(45, 'Black Tea', 20, 20, 1000, NULL, NULL, NULL, 1, NULL),
(46, 'Green Tea', 20, 20, 1000, NULL, NULL, NULL, 1, NULL),
(47, 'Hot Chocolate', 21, 20, 1000, NULL, NULL, NULL, 1, NULL),
(48, 'Hot Chocolate with Whipped Cream', 21, 20, 1000, NULL, NULL, NULL, 1, NULL),
(49, 'Cola', 22, 20, 100, NULL, NULL, NULL, 2, NULL),
(50, 'Orange Juice', 22, 20, 100, NULL, NULL, NULL, 2, NULL),
(51, 'Apple Juice', 22, 20, 100, NULL, NULL, NULL, 2, NULL),
(52, 'Strawberry Jam', 23, 20, 100, NULL, NULL, NULL, 2, NULL),
(53, 'Peach Jam', 23, 20, 100, NULL, NULL, NULL, 4, NULL),
(54, 'Plum Jam', 24, 20, 100, NULL, NULL, NULL, 4, NULL),
(55, 'Blueberry Jam', 24, 20, 100, NULL, NULL, NULL, 4, NULL),
(56, 'Rye Bread', 25, 20, 100, NULL, NULL, NULL, 4, NULL),
(57, 'Toasted Bread', 25, 20, 100, NULL, NULL, 2, NULL, NULL),
(58, 'Light Bread', 25, 20, 100, NULL, NULL, 2, NULL, NULL),
(59, 'Graham Roll', 26, 20, 100, NULL, NULL, 2, NULL, NULL),
(60, 'Wheat Roll', 26, 20, 100, NULL, NULL, 2, NULL, NULL);

INSERT INTO Packing VALUES
(1, 'On place', NULL),
(2, 'Takeaway', NULL);

INSERT INTO Payment VALUES
(1, 'Cash', NULL),
(2, 'Bank Transfer', NULL),
(3, 'Credit Card', NULL),
(4, 'Mobile Payment', NULL),
(5, 'Prepaid Card', NULL);

/*	

		Personal Data is random	generated in:			
			www.fakeaddressgenerator.com	

*/