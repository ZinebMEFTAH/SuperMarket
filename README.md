# Project Specifications - "My Online Grocery Store" 🛒💻

> **Project by:** MEFTAH Zineb, MEDJBER Syphax  
> **Group:** L2 Computer Science, Group G2

---

## Table of Contents

1. [Introduction](#introduction)
   - [1.1 Project Overview](#11-project-overview)
   - [1.2 Purpose of the Document](#12-purpose-of-the-document)
   - [1.3 Stakeholders](#13-stakeholders)
2. [Project Description](#project-description)
   - [2.1 Context and Challenges](#21-context-and-challenges)
   - [2.2 Specific Objectives](#22-specific-objectives)
3. [Functional Specifications](#functional-specifications)
   - [3.1 Supplier Management](#31-supplier-management)
   - [3.2 Product Management](#32-product-management)
   - [3.3 Purchase & Stock Management](#33-purchase-and-stock-management)
   - [3.4 Sales Management](#34-sales-management)
   - [3.5 Customer Management](#35-customer-management)
   - [3.6 User Management](#36-user-management)
   - [3.7 Log Management](#37-log-management)
   - [3.8 Dashboards and Reports](#38-dashboards-and-reports)
4. [Technical Specifications](#technical-specifications)
   - [4.1 Technologies Used](#41-technologies-used)
   - [4.2 System Architecture](#42-system-architecture)
   - [4.3 Security and Authentication](#43-security-and-authentication)
   - [4.4 Logging](#44-logging)
   - [4.5 Promotion Management](#45-promotion-management)
5. [Use Case Scenarios](#use-case-scenarios)
   - [5.1 Supplier & Contact Management](#51-supplier-contact-management)
   - [5.2 Product & Promotion Management](#52-product-promotion-management)
   - [5.3 Purchase (Batch) & Stock Management](#53-purchase-batch-stock-management)
   - [5.4 Sales & Customer Management](#54-sales-customer-management)
   - [5.5 Supplier Evaluation](#55-supplier-evaluation)
   - [5.6 User Management and Security](#56-user-management-security)
   - [5.7 Dashboards and Reports](#57-dashboards-reports)
6. [Key Modeling Strengths](#key-modeling-strengths)
7. [System Architecture Based on Modeling](#system-architecture)
8. [Legal and Regulatory Compliance](#legal-compliance)
   - [8.1 Personal Data Protection](#81-personal-data-protection)
   - [8.2 Data Security](#82-data-security)
   - [8.3 Legal Obligations](#83-legal-obligations)
9. [Project Management and Planning](#project-management)
   - [9.1 Project Management Methodology](#91-project-management-methodology)
   - [9.2 Tentative Schedule](#92-tentative-schedule)
   - [9.3 Resources](#93-resources)
   - [9.4 Risk Management](#94-risk-management)
10. [Quality Assurance](#quality-assurance)
    - [10.1 Testing Plan](#101-testing-plan)
    - [10.2 Performance Criteria](#102-performance-criteria)
    - [10.3 Code Review](#103-code-review)
11. [Maintenance and Support](#maintenance-support)
    - [11.1 Post-Deployment Support](#111-post-deployment-support)
    - [11.2 Backup Plan](#112-backup-plan)
    - [11.3 Scalability](#113-scalability)
12. [Acceptance Criteria](#acceptance-criteria)
    - [12.1 Compliance with Specifications](#121-compliance-specifications)
    - [12.2 Client Validation](#122-client-validation)
    - [12.3 Complete Documentation](#123-complete-documentation)
13. [Annexes](#annexes)
    - [13.1 Glossary](#131-glossary)
    - [13.2 References](#132-references)
    - [13.3 Schematics](#133-schematics)
14. [Conclusion](#conclusion)

---

## Introduction

### 1.1 Project Overview
- **Objective:** To fully computerize the management of a small grocery store through a command-line (terminal) application that optimizes supplier management, purchases, stocks, customers, and sales.
- **Vision and Mission:** Enhance operational efficiency and competitiveness by automating key processes while providing a user-friendly terminal interface.

### 1.2 Purpose of the Document
This document details the functional, technical, legal, and organizational specifications for the development of **"My Online Grocery Store"**. It serves as a reference for all stakeholders throughout the project's lifecycle.

### 1.3 Stakeholders
- **Client:** The store manager.
- **Development Team:** The student team responsible for the project.
- **End Users:** Store personnel (manager, cashiers, stock managers).
- **Suppliers:** Companies providing products to the store.

---

## Project Description

### 2.1 Context and Challenges
The grocery store aims to modernize its internal management by computerizing its processes to gain efficiency, reduce human errors, and optimize stock and sales management. The application will run in the terminal, providing a command-line interface tailored to the store's needs.

### 2.2 Specific Objectives
- **Centralized Supplier Management:** Facilitate adding, modifying, and deleting suppliers and access detailed supplier information.
- **Accurate Tracking of Purchases and Stocks:** Manage product batches, quantities, purchase dates, and expiration dates.
- **Optimized Sales Processing:** Record detailed sales for performance and trend analysis.
- **Intuitive Dashboards:** Provide the manager with analytical tools for sales, profits, orders, and stock management via the terminal.

---

## Functional Specifications

### 3.1 Supplier Management
- **Features:**
  - **CRUD Operations:** Add, modify, delete, and view suppliers.
  - **Detailed Information:** Includes company name, SIRET number, address, and primary email.
  - **Contract Management:** Track delivery commitments, minimum quantities, start and end dates, and fixed prices.
  - **Supplier Evaluation:** Users can rate suppliers, add comments, and record evaluation dates.

### 3.2 Product Management
- **Features:**
  - **CRUD Operations:** Add, modify, delete, and view products.
  - **Detailed Information:** Product name, detailed description, category, current sale price.
  - **Promotion Management:** Associate multiple promotions with a product, including discount percentages and validity dates.

### 3.3 Purchase & Stock Management
- **Batch Management:**
  - Each batch is uniquely identified (using `ID_LOT`) and linked to a product, supplier, and purchasing user.
  - Batch details include unit price, quantity, purchase date, and expiration date.
  - Full traceability from purchase to sale is ensured.

### 3.4 Sales Management
- **Sale Recording:**
  - Each sale is identified by `ID_VENTE` and includes the selling user, product, client, quantity, and unit price.
  - Detailed receipts (cash tickets) are generated.

### 3.5 Customer Management
- **Customer Information:**
  - Optionally store first and last names.
  - Track loyalty points (nbr_achat) for customer retention.

### 3.6 User Management
- **Authentication and Authorization:**
  - User details include username, hashed password, email, first name, last name, status, and role.
  - Role-based access control to protect sensitive data.

### 3.7 Log Management
- **Action Traceability:**
  - Automatic logging of all user actions with details such as action type, affected table, record ID, timestamp, and additional details.
  - Each log is linked to a user for accountability.

### 3.8 Dashboards and Reports
- **Advanced Analytics:**
  - Daily and monthly summaries (total sales, profits, top 10 by quantity and profit).
  - Order lists with options for validation, quantity adjustments, and supplier selection.
  - Calculation of average purchase price and monitoring of batches nearing expiration.
  - Supplier evaluations and promotion tracking.

---

## Technical Specifications

### 4.1 Technologies Used
- **Programming Language:** Java  
- **Database:** PostgreSQL  
- **User Interface:** Command-Line Application (CLI) executed in the terminal  
- **Execution Environment:** Unix/Linux compatible  
- **Security:** Access management and authentication via terminal

### 4.2 System Architecture
- **Layered Architecture:**
  - **User Interface:** Terminal interactions.
  - **Business Logic:** Application logic in Java.
  - **Data Access:** Communication with PostgreSQL via JDBC.

### 4.3 Security and Authentication
- **User Management:**
  - Secure password hashing (e.g., using bcrypt).
  - Role-based access control.
- **Data Protection:**
  - Encryption of sensitive stored data (optional).
- **Session Management:**
  - Authentication at the start of each terminal session (optional).

### 4.4 Logging
- **Detailed Logs:**
  - Automatic recording of critical user actions for auditing.
- **Log Files:**
  - Stored in dedicated files or database tables, accessible only to managers.

### 4.5 Promotion Management
- **Applying Promotions:**
  - Automatic calculation of reduced prices during sales.
  - Display promotions when viewing products via the terminal.

---

## Use Case Scenarios

### 5.1 Supplier & Contact Management
- **Actors:** Manager, Administrator  
- **Goal:** Efficiently manage suppliers and their associated contacts.  
- **Scenario:**  
  1. **Login:** The user launches the application and logs in.  
  2. **Add a Supplier:** The user selects "Manage Suppliers" and chooses "Add Supplier."  
  3. **Enter Information:** The user enters the company name, SIRET, address, and primary email.  
  4. **Add Contacts:** The user selects "Add Contact" to link contacts (name, surname, role, email, phone) to the supplier.

### 5.2 Product & Promotion Management
- **Actors:** Manager, Administrator  
- **Goal:** Manage the product catalog and associated promotions.  
- **Scenario:**  
  1. **Add a Product:** The user selects "Manage Products" and chooses "Add Product."  
  2. **Enter Details:** The user inputs the product name, detailed description, category, and current sale price.  
  3. **Link a Promotion:** The user selects "Add Promotion" from the promotions menu, sets the discount percentage and validity dates.

### 5.3 Purchase (Batch) & Stock Management
- **Actors:** Stock Manager  
- **Goal:** Manage product purchases and track stock levels.  
- **Scenario:**  
  1. **Record a Purchase:** The user selects "Manage Purchases" and chooses "Add Batch."  
  2. **Enter Batch Details:** The user enters product, supplier, quantity, unit price, purchase date, and expiration date.  
  3. **View Stocks:** The user views available quantities and batches nearing expiration.

### 5.4 Sales & Customer Management
- **Actors:** Cashier  
- **Goal:** Record sales and manage customer data.  
- **Scenario:**  
  1. **Record a Sale:** The user selects "Record Sale," inputs the `ID_LOT`, quantity sold, and customer details (if registered).  
  2. **Generate Receipt:** A detailed receipt is automatically generated.
  3. **Add a New Customer:** If necessary, the user adds new customer information.

### 5.5 Supplier Evaluation
- **Actors:** Manager, Stock Manager  
- **Goal:** Evaluate suppliers to improve business relationships.  
- **Scenario:**  
  1. **Access Evaluations:** The user selects "Evaluate Supplier" and chooses the supplier.  
  2. **Add Evaluation:** The user assigns a rating, writes a comment, and the evaluation date is recorded.  
  3. **Review Evaluations:** The history of evaluations is available for each supplier.

### 5.6 User Management and Security
- **Actors:** Administrator  
- **Goal:** Manage user accounts and ensure system security.  
- **Scenario:**  
  1. **Add a New User:** The administrator selects "Manage Users" and chooses "Add User."  
  2. **Enter User Details:** The administrator inputs the username, password (hashed), email, first name, last name, and role.
  3. **Modify Permissions:** The administrator can update roles and statuses as needed.
  4. **Authentication:** Each user must authenticate when launching the application.

### 5.7 Dashboards and Reports
- **Actors:** Manager  
- **Goal:** Access analytical dashboards to make strategic decisions.  
- **Scenario:**  
  1. **Access Dashboard:** The manager selects "Dashboard" from the main menu.
  2. **View Data:** Daily, monthly, and top 10 sales reports, order lists, and stock levels are displayed.
  3. **Decision Making:** Data insights inform decisions on ordering new products or launching promotions.

---

## 6. Key Strengths of the Modeling

- **Ease of Use:** A fast and efficient command-line interface designed for store personnel.
- **Performance:** A lightweight application with rapid response times.
- **Traceability:** Detailed logs of actions ensure full transparency.
- **Flexibility:** The modular design allows for future enhancements and new features.

---

## 7. System Architecture Based on Modeling

- **Multi-user Capability:** Supports multiple users on different terminals (planned).
- **Database Communication:** Uses JDBC to interact with PostgreSQL.
- **Terminal-Adapted MVC:** Separates business logic, command-line interface, and data access layers.

---

## 8. Legal and Regulatory Compliance

### 8.1 Personal Data Protection
- **GDPR Compliance:** Even for internal applications, personal data must be protected.

### 8.2 Data Security
- **Secure Storage:** Encryption of sensitive data (optional).
- **Access Control:** Role-based permissions ensure data safety.

### 8.3 Legal Obligations
- **Licensing:** Use of open-source software and libraries compliant with licensing requirements.

---

## 9. Project Management and Planning

### 9.1 Project Management Methodology
- **Iterative Approach:** Development will occur in sprints, incorporating stakeholder feedback at each cycle.
- **Project Phases:**
  - Requirements Analysis
  - Development of Core Features
  - Development of Advanced Features
  - Testing and Optimization
  - Deployment and Documentation

### 9.2 Tentative Schedule

| Phase                        | Description                        | Estimated Duration |
|------------------------------|------------------------------------|--------------------|
| Requirements Analysis        | Understanding the specifications   | 1 week             |
| Back-End Development         | Implementation of Java functionalities | 2 weeks         |
| Database Development         | Design of PostgreSQL tables         | 1 week             |
| Terminal Interface Development | Creation of CLI interactions         | 4 days          |
| Integration & Testing        | Unit and integration tests          | 1 week             |
| Deployment & Documentation   | Deployment and guide writing        | 4 days             |

### 9.3 Resources
- **Development Team:**
  - **Project Manager:** Overall project supervision.
  - **Java Developers:** Implement business logic and CLI.
  - **Database Specialist:** Design and manage PostgreSQL.

### 9.4 Risk Management
- **Technical Risks:** Delays due to incompatibility between the database and the application.
- **Mitigation Plan:**
  - Team training on PostgreSQL and JDBC.
  - Early testing to identify issues.
  - Regular review of project milestones.

---

## 10. Quality Assurance

### 10.1 Testing Plan
- **Unit Tests:** Each functionality is tested individually.
- **Integration Tests:** Verify communication between modules (CLI, database).
- **System Tests:** Full evaluation in a simulated environment.
- **User Acceptance Tests:** Real-world scenarios to ensure client requirements are met.

### 10.2 Performance Criteria
- **Response Time:** Terminal commands should execute within 2 seconds.
- **Stability:** The application must remain functional under prolonged or intensive use.

### 10.3 Code Review
- **Coding Standards:** Adherence to Java and PostgreSQL conventions.
- **Peer Reviews:** Each module is reviewed by another team member to identify issues.

---

## 11. Maintenance and Support

### 11.1 Post-Deployment Support
- **Corrective Maintenance:** Quick resolution of bugs after deployment.
- **Evolutionary Maintenance:** Addition of new features based on client needs.

### 11.2 Backup Plan
- **Regular Backups:** Automatic backup system for the database.

### 11.3 Scalability
- **Extensibility:** Flexible architecture to handle increased user load or transactions.

---

## 12. Acceptance Criteria

### 12.1 Compliance with Specifications
- **Operational Features:** All essential functionalities must be implemented and functional.
- **Performance:** The defined performance criteria should be met.

### 12.2 Client Validation
- **Acceptance Testing:** Use case scenarios will be executed in the presence of the client.
- **Feedback:** Adjustments will be made based on client feedback.

### 12.3 Complete Documentation
- **User Manual:** Detailed guide for using the terminal commands.
- **Technical Documentation:** Explanation of the architecture, code structure, and database schema.

---

## 13. Annexes

### 13.1 Glossary
- **CLI:** Command Line Interface.
- **DF:** Functional Dependency.
- **DM:** Multivalued Dependency.
- **CRUD:** Create, Read, Update, Delete operations.
- **DBMS:** Database Management System.

### 13.2 References
- **Coding Standards:** Java coding conventions.
- **Database Documentation:** Official PostgreSQL documentation.
- **Legal Texts:** GDPR – General Data Protection Regulation.

### 13.3 Schematics
- **Database Schema:** Diagrams of tables, attributes, primary and foreign keys.

---

## 14. Conclusion

This specification document provides a clear and detailed vision for the **"My Online Grocery Store"** project, which is designed as a command-line application. It details all the functional, technical, and organizational requirements needed for a successful project. Adhering to these specifications will ensure an efficient, high-performance application that meets the client's expectations.

---

## Acknowledgments

We extend our sincere thanks to everyone who contributed to the success of this project and to the users who trust us to enhance their store management experience.
