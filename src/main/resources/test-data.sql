CREATE TABLE IF NOT EXISTS employee (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        name VARCHAR(255),
    position VARCHAR(255),
    department VARCHAR(255)
    );


INSERT INTO employee (name, position, department) VALUES ('Test Employee Name', 'Developer', 'Engineering');
