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
	ImageURL VARCHAR(30) NULL
);
CREATE TABLE Customer (
	Id INTEGER PRIMARY KEY,
	Id_Adres INTEGER REFERENCES Adres(Id),
	Name VARCHAR(30) CHECK(LEN(Name) > 1) NOT NULL,
	Surname VARCHAR(30) CHECK(LEN(Surname) > 1) NOT NULL,
	ImageURL VARCHAR(30) NULL
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
	ImageURL VARCHAR(30) NULL
);
CREATE TABLE Category (
	Id INTEGER PRIMARY KEY,
	CategoryName VARCHAR(30) CHECK(LEN(CategoryName) > 1) UNIQUE NOT NULL,
	Id_Subcategory INTEGER REFERENCES Subcategory(Id),
	ImageURL VARCHAR(30) NULL
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
	ImageURL VARCHAR(30) NULL
);
CREATE TABLE Packing (
	Id INTEGER PRIMARY KEY,
	PackingType VARCHAR(30) CHECK(LEN(PackingType) > 1) UNIQUE NOT NULL,
	ImageURL VARCHAR(30) NULL
);
CREATE TABLE Payment (
	Id INTEGER PRIMARY KEY,
	PaymentType VARCHAR(30) CHECK(LEN(PaymentType) > 1) UNIQUE NOT NULL,
	ImageURL VARCHAR(30) NULL
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
(1, 1, 1, 'Grzegorz', 'Gorski', '93121235950', '1993-12-12', 'm', '192372881', 1, 'manager.jpg'),
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
(1, 'Peppa Pig', 1, 50, 0, 'Peppa Pig Cake! Perfect for kids!', 'flour, sugar, water, salt, milk', 2, NULL, '1.jpg'),
(2, 'Crying Smiling Emoji', 1, 10, 0, 'Crying Smiling Emoji Cake! Perfect for kids!', 'flour, sugar, water, salt, milk', 2, NULL, '2.jpg'),
(3, 'Angel White', 2, 100, 0, 'Angel White cake, beauty and alagance', 'flour, sugar, water, salt, white chocolate, milk', 2, NULL, '3.jpg'),
(4, 'Love Chocolate', 2, 150, 0, 'Best Wedding Cake!', 'flour, sugar, water, salt, dark chocolate, milk', 2, NULL, '4.jpg'),
(5, 'Holy Bible', 3, 50, 0, 'Looks like real book! Perfect for first communion', 'flour, sugar, water, salt, milk', 2, NULL, '5.jpg'),
(6, 'Cake with Hoste', 3, 60, 0, 'Looks real! Perfect for first communion', 'flour, sugar, water, salt, milk', 2, NULL, '6.jpg'),
(7, 'Little Baby White', 4, 25, 0, 'Little Baby White, perfect for your little baby', 'flour, sugar, water, salt, milk', 2, NULL, '7.jpg'),
(8, 'Little Baby Blue', 4, 25, 0, 'Little Baby Blue - perfect for your little baby', 'flour, sugar, water, salt, milk', 2, NULL, '8.jpg'),
(9, 'Raspberry Cake', 5, 20, 10, 'Fresh cake with fruits', 'flour, sugar, water, salt, raspberry, milk', 2, NULL, '9.jpg'),
(10, 'Blueberry Cake', 5, 20, 10, 'Fresh cake with fruits', 'flour, sugar, water, salt, blueberry, milk', 2, NULL, '10.jpg'),
(11, 'Lemon Cake', 5, 20, 10, 'Fresh cake with fruits', 'flour, sugar, water, salt, lemons, milk', 2, NULL, '11.jpg'),
(12, 'Black Currant', 6, 10, 30, 'Fresh cake with fruits', 'flour, sugar, water, salt, black currant, milk', 2, NULL, '12.jpg'),
(13, 'Peach Cheesecake', 6, 7, 30, 'Fresh cake', 'flour, sugar, water, salt, peach, cheese, milk', 2, NULL, '13.jpg'),
(14, 'Rool Beige', 7, 20, 30, 'Fresh and tasty', 'flour, sugar, water, salt, milk', 2, NULL, '14.jpg'),
(15, 'Big Mix', 8, 20, 0, 'Mixed snacks buch of them option', 'flour, sugar, water, salt, milk', 3, NULL, '15.jpg'),
(16, 'Small Mix', 8, 30, 0, 'Mixed snacks less of them option', 'flour, sugar, water, salt, milk', 3, NULL, '16.jpg'),
(17, 'Chocolate cake', 9, 50, 30, 'Fresh and tasty cake with chocolate', 'flour, sugar, water, salt, milk, chocolate', 2, NULL, '17.jpg'),
(18, 'Brioche', 9, 20, 30, 'Fresh and tasty cake', 'flour, sugar, water, salt, milk', 2, NULL, '18.jpg'),
(19, 'Traditional Cheesecake', 10, 20, 30, 'Fresh and tasty cake', 'flour, sugar, water, salt, milk, cheese', 2, NULL, '19.jpg'),
(20, 'Home Cheesecake', 10, 20, 30, 'Fresh and tasty cake', 'flour, sugar, water, salt, milk, cheese', 2, NULL, '20.jpg'),
(21, 'Crispy Cheesecake', 10, 20, 30, 'Fresh and tasty cake', 'flour, sugar, water, salt, milk, cheese', 2, NULL, '21.jpg'),
(22, 'Dessert Apple Pie', 11, 20, 30, 'Fresh and tasty cake with apples', 'flour, sugar, water, salt, milk, apples', 2, NULL, '22.jpg'),
(23, 'Traditional Apple Pie', 11, 20, 30, 'Fresh and tasty cake with apples', 'flour, sugar, water, salt, milk, apples', 2, NULL, '23.jpg'),
(24, 'Poppy Seed Cake', 12, 20, 30, 'Fresh and tasty cake', 'flour, sugar, water, salt, milk, poppy seeds', 2, NULL, '24.jpg'),
(25, 'Yogurt Cake With Rhubarb', 12, 20, 30, 'Fresh and tasty cake', 'flour, sugar, water, salt, milk, rhubarb, yogurt', 2, NULL, '25.jpg'),
(26, 'Gooseberry Tart', 13, 20, 30, 'Fresh and tasty cake', 'flour, sugar, water, salt, milk, gooseberry', 2, NULL, '26.jpg'),
(27, 'Cheese Tart', 13, 20, 30, 'Fresh and tasty cake', 'flour, sugar, water, salt, milk, cheese', 2, NULL, '27.jpg'),
(28, 'Chocolate Cookies', 16, 20, 30, 'Fresh and tasty cookies', 'flour, sugar, water, salt, milk, chocolate', 2, NULL, '28.jpg'),
(29, 'Oatmeal Cookies', 16, 20, 30, 'Fresh and tasty cookies', 'flour, sugar, water, salt, milk no gluten', 2, NULL, '29.jpg'),
(30, 'Cupcakes With Chocolate', 14, 20, 30, 'Fresh and tasty cupcakes', 'flour, sugar, water, salt, milk, chocolate', 2, NULL, '30.jpg'),
(31, 'Cupcakes With Vanilla', 14, 20, 30, 'Fresh and tasty cupcakes', 'flour, sugar, water, salt, milk, vanilla ice-cream', 2, NULL, '31.jpg'),
(32, 'Apple Cake Big', 15, 20, 30, 'Fresh and tasty cake with frouits big edition', 'flour, sugar, water, salt, milk, apple', 2, NULL, '32.jpg'),
(33, 'Apple Cake Small', 15, 20, 30, 'Fresh and tasty cake with frouits small edition', 'flour, sugar, water, salt, milk, apple', 2, NULL, '33.jpg'),
(34, 'Mini Dessert Mango', 15, 20, 30, 'Fresh and tasty dessert with frouits', 'flour, sugar, water, salt, milk, mango', 3, NULL, '34.jpg'),
(35, 'Mini Dessert Panna Cotta', 15, 20, 30, 'Fresh and tasty dessert with frouits', 'flour, sugar, water, salt, milk', 3, NULL, '35.jpg'),
(36, 'Raspberry Bliss', 17, 20, 30, 'Fresh and tasty', 'flour, sugar, water, salt, milk rasberry', 3, 3, '36.jpg'),
(37, 'Chocolate Temptation', 17, 20, 30, 'Fresh and tasty cake with chocolate', 'flour, sugar, water, salt, milk, chocolate', 3, 3, '37.jpg'),
(38, 'Chocolate', 18, 20, 100, 'Fresh and cold chocolate ice-cream', 'water, milk, sugar', 3, 3, '38.jpg'),
(39, 'Vanilla', 18, 20, 100, 'Fresh and cold vanilla ice-cream', 'water, milk, sugar', 3, 3, '39.jpg'),
(40, 'Salty Caramel', 18, 20, 100, 'Fresh and cold salty caramel taste ice-cream', 'water, milk, sugar', 3, 3, '40.jpg'),
(41, 'Creamy', 18, 20, 100, 'Fresh and cold creamy ice-cream', 'water, milk, sugar', 2, 3, '41.jpg'),
(42, 'Espresso', 19, 20, 1000, 'Hot delicious coffe', 'water, coffe', NULL, 1, '42.jpg'),
(43, 'Cappuciono', 19, 20, 1000, 'Hot delicious coffe', 'water, coffe, cynamon, milk', NULL, 1, '43.jpg'),
(44, 'Late Macchiato', 19, 20, 1000, 'Hot delicious coffe', 'water, coffe, milk, sugar', NULL, 1, '44.jpg'),
(45, 'Black Tea', 20, 20, 1000, 'Hot delicious tea', 'water, black tea', NULL, 1, '45.jpg'),
(46, 'Green Tea', 20, 20, 1000, 'Hot delicious tea', 'water, green tea', NULL, 1, '46.jpg'),
(47, 'Hot Chocolate', 21, 20, 1000, 'Hot delicious liquid chocolate', 'water, milk, sugar, chocolate', NULL, 1, '47.jpg'),
(48, 'Hot Chocolate with Whipped Cream', 21, 20, 1000, 'Hot delicious liquid chocolate', 'water, milk, sugar, chocolate, cream', NULL, 1, '48.jpg'),
(49, 'Cola', 22, 20, 100, 'refreshment drink', 'water, sugar, caramel', NULL, 2, '49.jpg'),
(50, 'Orange Juice', 22, 20, 100, 'fresh juice 100% ', 'water, sugar, orange juice', NULL, 2, '50.jpg'),
(51, 'Apple Juice', 22, 20, 100, 'fresh juice 100% ', 'water, sugar, apple juice', NULL, 2, '51.jpg'),
(52, 'Strawberry Jam', 23, 20, 100, 'delicious homemade jam', 'water, sugar, strawberry', NULL, 2, '52.jpg'),
(53, 'Peach Jam', 23, 20, 100, 'delicious homemade jam', 'water, sugar, peach', NULL, 4, '53.jpg'),
(54, 'Plum Jam', 24, 20, 100, 'delicious homemade jam', 'water, sugar, plum', NULL, 4, '54.jpg'),
(55, 'Blueberry Jam', 24, 20, 100, 'delicious homemade jam', 'water, sugar, blueberry', NULL, 4, '55.jpg'),
(56, 'Rye Bread', 25, 20, 100, 'fresh fragrant bread', 'water, flour, salt', NULL, 4, '56.jpg'),
(57, 'Toasted Bread', 25, 20, 100, 'fresh fragrant bread', 'water, flour, salt', 2, NULL, '57.jpg'),
(58, 'Light Bread', 25, 20, 100, 'fresh fragrant bread', 'water, flour, salt', 2, NULL, '58.jpg'),
(59, 'Graham Roll', 26, 20, 100, 'fresh fragrant rolls', 'water, flour, salt', 2, NULL, '59.jpg'),
(60, 'Wheat Roll', 26, 20, 100, 'fresh fragrant rolls', 'water, flour, salt', 2, NULL, '60.jpg');

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

SELECT Product.Id, Product.ProductName, Product.Price, Product.Amount, Product.ImageURL, Product.Desctiprion, Product.Composition, Employee.Name, Employee.Surname, Supplier.CompanyName, Category.CategoryName 
FROM Product LEFT JOIN Employee ON Employee.Id = Product.Id_Baker LEFT JOIN Supplier ON Supplier.Id = Product.Id_Supplier INNER JOIN Category ON Category.Id = Product.Id_Category

--SELECT ProductName FROM Product