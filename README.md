# 🛒 My Online Supermarket - Project Specification

## 📌 Project Overview

**"My Online Supermarket"** is a **command-line-based** application designed to digitalize and optimize the management of a supermarket. The system streamlines supplier interactions, product inventory, customer transactions, sales, and reports through a well-structured terminal-based interface.

> **Developed by:**  
> - **Meftah Zineb**
> - **Medjber Syphax** 

---

## 📖 Table of Contents

1. [Introduction](#introduction)  
   - [1.1 Project Presentation](#11-project-presentation)  
   - [1.2 Document Objective](#12-document-objective)  
   - [1.3 Stakeholders](#13-stakeholders)  
2. [Project Description](#project-description)  
   - [2.1 Context & Challenges](#21-context--challenges)  
   - [2.2 Specific Objectives](#22-specific-objectives)  
3. [Functional Specifications](#functional-specifications)  
   - [3.1 Supplier Management](#31-supplier-management)  
   - [3.2 Product Management](#32-product-management)  
   - [3.3 Stock & Purchase Management](#33-stock--purchase-management)  
   - [3.4 Sales Management](#34-sales-management)  
   - [3.5 Customer Management](#35-customer-management)  
   - [3.6 User Management](#36-user-management)  
   - [3.7 Logging System](#37-logging-system)  
   - [3.8 Dashboards & Reports](#38-dashboards--reports)  
4. [Technical Specifications](#technical-specifications)  
   - [4.1 Technologies Used](#41-technologies-used)  
   - [4.2 System Architecture](#42-system-architecture)  
   - [4.3 Security & Authentication](#43-security--authentication)  
   - [4.4 Logging Actions](#44-logging-actions)  
   - [4.5 Promotions Management](#45-promotions-management)  
5. [Usage Scenarios](#usage-scenarios)  
6. [System Architecture](#system-architecture)  
7. [Legal & Compliance](#legal--compliance)  
8. [Project Management & Planning](#project-management--planning)  
9. [Quality Assurance](#quality-assurance)  
10. [Maintenance & Support](#maintenance--support)  
11. [Acceptance Criteria](#acceptance-criteria)  
12. [Annexes](#annexes)  
13. [Conclusion](#conclusion)  

---

## 🔹 Introduction

### 1.1 Project Presentation  
The goal of **"My Online Supermarket"** is to fully digitalize a supermarket’s operations via a **command-line-based application**. This system optimizes interactions with **suppliers, customers, and products**, ensuring better stock management and seamless sales operations.

### 1.2 Document Objective  
This document serves as the **official specification** for the development of the project, outlining the **functional**, **technical**, and **organizational** requirements.

### 1.3 Stakeholders  
- **Client**: The supermarket manager  
- **Development Team**: Students in charge of implementation  
- **End Users**: Store personnel (managers, cashiers, inventory controllers)  
- **Suppliers**: Companies providing the products  

---

## 📌 Project Description

### 2.1 Context & Challenges  
Supermarkets require **efficient inventory and sales tracking** to maintain a profitable business. This system eliminates **manual errors**, improves stock visibility, and simplifies purchasing and sales through a structured **CLI (Command-Line Interface)**.

### 2.2 Specific Objectives  
✅ **Centralized Supplier Management** - Add, update, and remove suppliers.  
✅ **Optimized Stock & Sales Tracking** - Track product batches, stock levels, and transactions.  
✅ **Real-Time Sales Data** - Generate instant reports and track customer purchases.  
✅ **Dashboard Analytics** - Provide key insights into store performance.  

---

## 📌 Functional Specifications

### 3.1 Supplier Management  
- **CRUD Operations**: Add, modify, delete, and view suppliers.  
- **Contract Management**: Track agreements, delivery schedules, and pricing.  
- **Supplier Evaluation**: Rate and review suppliers based on performance.

### 3.2 Product Management  
- **CRUD Operations**: Manage product inventory with descriptions, categories, and pricing.  
- **Promotions & Discounts**: Apply time-limited discounts for specific products.

### 3.3 Stock & Purchase Management  
- **Lot-Based Tracking**: Manage product batches with details like supplier, expiry date, and quantity.  
- **Automated Reordering**: Notify when stock is low.  

### 3.4 Sales Management  
- **Transaction Logging**: Record sales per customer, with detailed invoices.  
- **Discount Handling**: Automatically apply promotions to qualifying products.

### 3.5 Customer Management  
- **Loyalty System**: Track purchase history and assign reward points.  
- **Customer Profiles**: Store customer details for personalized offers.

### 3.6 User Management  
- **Role-Based Access**: Admin, Store Manager, Cashier, and Employee roles with different permissions.  
- **Secure Authentication**: Password hashing and secure login.

### 3.7 Logging System  
- **Action Tracking**: Log all operations for security and audit purposes.  

### 3.8 Dashboards & Reports  
- **Sales Insights**: View top-selling products, profit margins, and pending stock.  
- **Supplier Reports**: Analyze supplier performance based on pricing and delivery speed.

---

## 📌 Technical Specifications

### 4.1 Technologies Used  
- **Programming Language**: Java  
- **Database**: PostgreSQL  
- **Interface**: Command-Line Interface (CLI)  

### 4.2 System Architecture  
- **Layered Architecture**: Separation between **business logic, CLI, and database interaction**.  

### 4.3 Security & Authentication  
- **User Authentication**: Encrypted password storage.  
- **Access Control**: Role-based permission system.

### 4.4 Logging Actions  
- **Audit Trail**: Store user actions and modifications.

### 4.5 Promotions Management  
- **Automated Discounts**: Apply price reductions based on promotion rules.  

---

## 📌 Project Management & Planning

### 8.1 Development Phases  
| **Phase**                | **Description** | **Estimated Duration** |
|-------------------------|----------------|---------------------|
| Requirements Analysis   | Understanding client needs | 1 week |
| Backend Development    | Java implementation | 2 weeks |
| Database Setup         | PostgreSQL Schema Design | 1 week |
| CLI Development        | User interaction & commands | 4 days |
| Testing & Optimization | Unit and integration testing | 1 week |
| Deployment & Documentation | Final release & user guide | 4 days |

---

## 📌 Maintenance & Support  
- **Bug Fixes & Updates**: Continuous improvements based on user feedback.  
- **Backup System**: Regular database backups to prevent data loss.  

---

## 📌 Acceptance Criteria  
✅ **Fully Functional Features**: All described functionalities must be implemented.  
✅ **Performance Standards**: Commands must execute within **2 seconds**.  
✅ **Security & Compliance**: Proper access control and encrypted credentials.  
✅ **User Satisfaction**: End-users must validate system usability.  

---

## 📌 Conclusion  
This project aims to **revolutionize supermarket operations** by offering an **efficient, secure, and reliable command-line-based management system**. Following this detailed specification will ensure a **successful and well-structured implementation**.

---

## 🔗 Contact  
📧 **Email:** [meftahworld@gmail.com](mailto:meftahworld@gmail.com)  
💼 **LinkedIn:** [Meftah Zineb](https://www.linkedin.com/in/meftah-zineb-5768ba25b)  
🌍 **Portfolio:** [VotrePortfolio.com](https://votreportfolio.com)  
