CREATE TABLE IF NOT EXISTS employee (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL,
    position VARCHAR(255),
    department VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS schedule (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        date DATE NOT NULL,
                                        shift VARCHAR(255),
    employee_id BIGINT,
    FOREIGN KEY (employee_id) REFERENCES Employee(id)
    );

CREATE TABLE IF NOT EXISTS task (
                                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    description TEXT,
                                    status VARCHAR(255),
    employee_id BIGINT,
    FOREIGN KEY (employee_id) REFERENCES Employee(id)
    );
