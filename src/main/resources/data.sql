-- Insert products
INSERT INTO products (id, code, name, price_eur, price_usd, description) VALUES
                                                                             (101, 'PRD000000000001', 'Smartphone X1', 199.99, 216.22, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed et nisi nec elit consequat faucibus.'),
                                                                             (102, 'PRD000000000002', 'Laptop Pro 2000', 799.99, 864.92, 'Nullam tincidunt lectus eget urna convallis, non malesuada magna scelerisque. Quisque sit amet viverra magna.'),
                                                                             (103, 'PRD000000000003', 'Wireless Headphones A2', 99.99, 108.11, 'Duis ultricies odio sit amet nisl dictum, vel rutrum neque pharetra. Vivamus tincidunt, velit vel tincidunt luctus.'),
                                                                             (104, 'PRD000000000004', 'Smartwatch 3', 299.99, 324.34, 'Curabitur nec elit nec lectus dapibus vehicula eu eu turpis. Vivamus nec mi vel ligula elementum aliquet.'),
                                                                             (105, 'PRD000000000005', 'Gaming Console S1', 399.99, 432.46, 'Pellentesque vitae libero a erat sollicitudin suscipit. Nam sagittis mi nec tortor luctus convallis.'),
                                                                             (106, 'PRD000000000006', 'Fitness Tracker F4', 149.99, 162.16, 'Fusce rhoncus nisi non mauris luctus, ut tincidunt quam aliquet. Integer euismod eros nec purus vehicula.'),
                                                                             (107, 'PRD000000000007', 'Tablet Z10', 499.99, 540.57, 'Vivamus blandit enim a ipsum malesuada interdum. In hac habitasse platea dictumst. Morbi sit amet posuere dui.');

-- Insert reviews for Product 1
INSERT INTO reviews (id, product_id, reviewer, text, rating) VALUES
                                                                 (1, 101, 'John Doe', 'Great product!', 5),
                                                                 (2, 101, 'Jane Smith', 'Not bad, but could be better.', 3);


-- Insert reviews for Product 2
INSERT INTO reviews (id, product_id, reviewer, text, rating) VALUES
                                                                 (3, 102, 'Alice Johnson', 'Excellent quality!', 5),
                                                                 (4, 102, 'Bob Brown', 'Good value for money.', 4),
                                                                 (17, 102, 'Ethan Thompson', 'Average performance.', 3),
                                                                 (18, 102, 'Emma Garcia', 'Sleek design.', 5);


-- Insert reviews for Product 3
INSERT INTO reviews (id, product_id, reviewer, text, rating) VALUES
                                                                 (5, 103, 'Emily Davis', 'Impressive features.', 5),
                                                                 (6, 103, 'Michael Wilson', 'Average product.', 3),
                                                                 (19, 103, 'Mia Rodriguez', 'Could be improved.', 3),
                                                                 (20, 103, 'Noah Martinez', 'Decent sound quality.', 4),
                                                                 (33, 103, 'Harper Allen', 'Comfortable to wear for long periods.', 4),
                                                                 (34, 103, 'Aiden Young', 'Great connectivity.', 5);

-- Insert reviews for Product 4
INSERT INTO reviews (id, product_id, reviewer, text, rating) VALUES
                                                                 (7, 104, 'Sophia Martinez', 'Love it!', 5),
                                                                 (8, 104, 'William Anderson', 'Not satisfied with the performance.', 2),
                                                                 (21, 104, 'Ava Hernandez', 'Great features.', 4),
                                                                 (22, 104, 'Liam Thomas', 'Excellent battery life.', 5),
                                                                 (35, 104, 'Charlotte Baker', 'Good for tracking workouts.', 4);


-- Insert reviews for Product 5
INSERT INTO reviews (id, product_id, reviewer, text, rating) VALUES
                                                                 (9, 105, 'Olivia Taylor', 'Highly recommended.', 5),
                                                                 (10, 105, 'James Thomas', 'Could be improved.', 3),
                                                                 (23, 105, 'Isabella Brown', 'Great for gaming.', 5),
                                                                 (24, 105, 'Mason Jackson', 'Good value for money.', 4),
                                                                 (37, 105, 'Luna Harris', 'Smooth graphics and fast processing.', 5),
                                                                 (38, 105, 'Henry Clark', 'Easy setup and user-friendly interface.', 4),
                                                                 (41, 105, 'Harper Davis', 'Good battery life.', 4);

-- Insert reviews for Product 6
INSERT INTO reviews (id, product_id, reviewer, text, rating) VALUES
                                                                 (11, 106, 'Isabella Hernandez', 'Awesome product!', 5),
                                                                 (12, 106, 'Liam Moore', 'Slightly overpriced.', 4);


-- Insert reviews for Product 7
INSERT INTO reviews (id, product_id, reviewer, text, rating) VALUES
                                                                 (13, 107, 'Amelia Martin', 'Fantastic!', 5),
                                                                 (14, 107, 'Benjamin Jackson', 'Decent product.', 3),
                                                                 (27, 107, 'Avery Lee', 'Great for watching movies.', 4);

