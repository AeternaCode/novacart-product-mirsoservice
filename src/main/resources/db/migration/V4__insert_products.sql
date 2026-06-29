INSERT INTO products
(product_name, product_image_url, product_brand, rating, product_description, price, stock_quantity, category_id)
VALUES

-- Electronics
('iPhone 15', 'iphone15.jpg', 'Apple', 4.8, 'Latest Apple smartphone with A17 chip', 79999.00, 25, 1),
('Galaxy S24', 'galaxys24.jpg', 'Samsung', 4.7, 'Flagship Samsung Android phone', 74999.00, 30, 1),
('MacBook Air M3', 'macbookm3.jpg', 'Apple', 4.9, 'Lightweight laptop with M3 chip', 129999.00, 10, 1),
('Sony WH-1000XM5', 'sonyheadphones.jpg', 'Sony', 4.6, 'Noise cancelling wireless headphones', 24999.00, 40, 1),
('LG OLED TV', 'lgtv.jpg', 'LG', 4.5, '55 inch OLED smart television', 89999.00, 8, 1),
('Boat Rockerz 450', 'boat450.jpg', 'Boat', 4.1, 'Affordable wireless headphones', 1499.00, 100, 1),
('Dell Inspiron 15', 'dellinspiron.jpg', 'Dell', 4.3, 'Everyday productivity laptop', 58999.00, 18, 1),
('Canon EOS 1500D', 'canon1500d.jpg', 'Canon', 4.4, 'DSLR camera for beginners', 42999.00, 12, 1),

-- Clothing
('Men Black Hoodie', 'hoodie.jpg', 'H&M', 4.2, 'Comfortable winter hoodie', 1999.00, 60, 2),
('Women Blue Jeans', 'jeans.jpg', 'Levis', 4.4, 'Slim fit blue jeans', 2999.00, 45, 2),
('Nike Running T-Shirt', 'niketshirt.jpg', 'Nike', 4.5, 'Breathable sports t-shirt', 1499.00, 70, 2),
('Puma Track Pants', 'pumapants.jpg', 'Puma', 4.1, 'Comfortable gym wear', 1799.00, 55, 2),
('Formal White Shirt', 'formalshirt.jpg', 'Allen Solly', 4.3, 'Office wear formal shirt', 2499.00, 35, 2),
('Leather Jacket', 'jacket.jpg', 'Zara', 4.6, 'Stylish leather jacket', 6999.00, 15, 2),
('Women Kurti', 'kurti.jpg', 'Biba', 4.0, 'Traditional cotton kurti', 1299.00, 50, 2),
('Adidas Sweatshirt', 'sweatshirt.jpg', 'Adidas', 4.4, 'Warm casual sweatshirt', 3499.00, 25, 2),

-- Books
('Atomic Habits', 'atomic.jpg', 'Penguin', 4.9, 'Self improvement bestseller', 499.00, 120, 3),
('Clean Code', 'cleancode.jpg', 'Prentice Hall', 4.8, 'Software craftsmanship guide', 899.00, 40, 3),
('Rich Dad Poor Dad', 'richdad.jpg', 'Plata Publishing', 4.5, 'Personal finance classic', 399.00, 80, 3),
('The Alchemist', 'alchemist.jpg', 'Harper', 4.6, 'Inspirational fiction novel', 299.00, 65, 3),
('Deep Work', 'deepwork.jpg', 'Grand Central', 4.4, 'Focus and productivity book', 550.00, 50, 3),
('Harry Potter Set', 'harrypotter.jpg', 'Bloomsbury', 4.9, 'Fantasy novel collection', 3499.00, 20, 3),
('Think and Grow Rich', 'thinkrich.jpg', 'Success Books', 4.3, 'Mindset and wealth book', 350.00, 90, 3),

-- Sports
('Cricket Bat', 'bat.jpg', 'MRF', 4.5, 'Professional English willow bat', 5999.00, 18, 4),
('Football', 'football.jpg', 'Nivia', 4.2, 'Training football size 5', 899.00, 75, 4),
('Badminton Racket', 'racket.jpg', 'Yonex', 4.6, 'Lightweight badminton racket', 2499.00, 30, 4),
('Gym Gloves', 'gloves.jpg', 'Nike', 4.1, 'Workout gloves for gym', 699.00, 100, 4),
('Yoga Mat', 'yogamat.jpg', 'Boldfit', 4.3, 'Non-slip yoga mat', 1199.00, 40, 4),
('Tennis Ball Pack', 'tennisballs.jpg', 'Cosco', 4.0, 'Pack of 6 tennis balls', 499.00, 85, 4),

-- Furniture
('Office Chair', 'chair.jpg', 'Green Soul', 4.5, 'Ergonomic office chair', 8999.00, 15, 5),
('Wooden Study Table', 'studytable.jpg', 'Ikea', 4.4, 'Minimal wooden desk', 6999.00, 10, 5),
('Queen Bed', 'queenbed.jpg', 'Wakefit', 4.6, 'Queen size storage bed', 24999.00, 5, 5),
('Bookshelf', 'bookshelf.jpg', 'Home Centre', 4.2, '5 layer bookshelf', 4999.00, 12, 5),
('Sofa Set', 'sofa.jpg', 'Urban Ladder', 4.3, '3 seater sofa set', 32999.00, 4, 5),
('Dining Table', 'diningtable.jpg', 'Pepperfry', 4.1, '6 seater dining table', 18999.00, 6, 5),

-- Beauty
('Face Wash', 'facewash.jpg', 'Nivea', 4.2, 'Refreshing face cleanser', 299.00, 100, 6),
('Lipstick', 'lipstick.jpg', 'Lakme', 4.5, 'Long lasting matte lipstick', 599.00, 80, 6),
('Perfume', 'perfume.jpg', 'Titan', 4.4, 'Premium fragrance perfume', 2499.00, 25, 6),
('Hair Dryer', 'hairdryer.jpg', 'Philips', 4.3, 'Compact hair dryer', 1999.00, 35, 6),
('Body Lotion', 'lotion.jpg', 'Vaseline', 4.1, 'Moisturizing body lotion', 399.00, 90, 6),

-- Toys
('Remote Control Car', 'rccar.jpg', 'Hot Wheels', 4.5, 'Rechargeable RC car', 2499.00, 30, 7),
('Lego Classic Set', 'lego.jpg', 'Lego', 4.9, 'Creative building blocks', 3999.00, 18, 7),
('Barbie Doll', 'barbie.jpg', 'Mattel', 4.3, 'Classic Barbie doll', 1499.00, 45, 7),
('Puzzle Game', 'puzzle.jpg', 'Funskool', 4.1, '1000 piece puzzle game', 799.00, 40, 7),
('Toy Train', 'train.jpg', 'Chicco', 4.0, 'Battery operated train set', 1799.00, 22, 7),

-- Groceries
('Basmati Rice 5kg', 'rice.jpg', 'India Gate', 4.7, 'Premium basmati rice', 699.00, 100, 8),
('Olive Oil', 'oliveoil.jpg', 'Figaro', 4.5, 'Extra virgin olive oil', 899.00, 50, 8),
('Green Tea', 'greentea.jpg', 'Lipton', 4.2, 'Healthy green tea bags', 299.00, 75, 8),
('Peanut Butter', 'peanutbutter.jpg', 'MyFitness', 4.6, 'High protein peanut butter', 449.00, 65, 8),
('Dark Chocolate', 'chocolate.jpg', 'Amul', 4.4, 'Premium dark chocolate', 199.00, 120, 8);
