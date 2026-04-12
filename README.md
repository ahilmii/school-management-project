<h1>School Management Project</h1>

<p>The goal of this project is to develop a robust REST-API web application using the Java 25 and Spring Boot 4.0.1 framework. The system is designed to manage Professors, Courses, and their complex assignments (Teaches) with high data integrity.</p>

<h3>Technical Stack</h3>
<ul>
  <li><b>JDK:</b> 25</li>
  <li>Framework: Spring Boot 4.0.1</li>
  <li>Build Tool: Maven 4.0.0</li>
  <li>Database: PostgreSQL</li>
  <li>Documentation: Swagger / OpenAPI 2.8.9</li>
</ul>

<h3>Key Features & Implementation Details</h3>
<ul>
<li><b>Architectural Design:</b> Repository, Service and Controller layers designed and implemented carefully to ensure separation of concerns.</li>  
<li><b>Data Transfer Objects (DTO):</b> Strict compliance with the "No Entity to Controller" rule. All data exchanges are handled via specialized RequestDTO and ResponseDTO classes, utilizing Manual Mapping (viewAsDTO) for high performance.</li>
<li><b>Logging:</b> New data insertions and manipulations creates a log line at standart output.</li>
<li><b>Global Exception Handling:</b> Centralized error management using @ControllerAdvice. Custom exceptions like ResourceNotFoundException and ResourceAlreadyExistsException return standardized, user-friendly JSON error responses</li>
<li><b>Relationship Management:</b> Handles Many-to-Many relationships between Professors and Courses via a dedicated Teaches relational table, supporting full CRUD operations.</li>
<li>All exceptions and errors handled carefully creating proper logs.</li>  
<li>End-points has been controlled via Postman. Application endpoints documented with Swagger.</li>
</ul>   

<img width="1386" height="525" alt="update" src="https://github.com/user-attachments/assets/61aa9bab-f0dc-43e2-87f5-cd812d283b5e" />
<img width="1500" height="336" alt="delete" src="https://github.com/user-attachments/assets/5ce901d3-6ff5-49d9-b00c-0fcd729c1b04" />
<img width="1752" height="503" alt="get" src="https://github.com/user-attachments/assets/4927893b-0104-4313-9029-7c8d9a6dbbcc" />






