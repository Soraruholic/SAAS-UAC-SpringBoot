CREATE TABLE IF NOT EXISTS User (
    userID VARCHAR(255) NOT NULL,
    userName VARCHAR(255) NOT NULL,
    userPassword VARCHAR(255) NOT NULL,
    userEmail VARCHAR(255) NOT NULL,
    userPhone VARCHAR(255) NOT NULL,
    lastPasswordResetDate VARCHAR(255) NOT NULL,
    PRIMARY KEY (userID)
);