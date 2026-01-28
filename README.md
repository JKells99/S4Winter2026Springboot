# ScreenTime API – TV & Movie Catalog

## Project Overview

In this project, you will build a **Spring Boot REST API** that manages a catalog of **Movies and TV Shows**. The system will store information about content, the studios that produce them, the genres they belong to, and (for TV shows) their seasons.

This project focuses on **backend fundamentals**:

* REST API structure
* Entity relationships
* CRUD operations
* Service-layer business rules
* Clean project organization

❌ No authentication
❌ No security
---

## Learning Objectives

By completing this project, you should be able to:

* Design RESTful endpoints using Spring Boot
* Model One-to-Many and Many-to-Many relationships
* Use enums to represent domain rules
* Apply validation and business logic in a service layer
* Structure a Spring Boot project cleanly and consistently

---

## Entities Overview (4 Total)

### 1️⃣ Content

Represents either a **Movie** or a **TV Series**.

**Fields**

* `id`
* `title`
* `genres` (list)
* `releaseYear`
* `rating`
* `type` (MOVIE | SERIES)
* `studio` (can only have one studio)

**Relationships**

* Many Content → One Studio
* Many Content ↔ Many Genres
* One Content → Many Seasons (SERIES only)

---

### 2️⃣ Season

Represents a season of a TV show.

**Fields**

* `id`
* `seasonNumber`
* `episodeCount`
* `content`

**Relationships**

* One Content → Many Seasons

> Seasons may only exist for content with type `SERIES`.

---

### 3️⃣ Genre

Represents a category such as Drama, Comedy, Action, etc.

**Fields**

* `id`
* `name`

**Relationships**

* Many Genres ↔ Many Content

---

### 4️⃣ Studio

Represents the company that produced the content.

**Fields**

* `id`
* `name`
* `country`
* `foundedYear`

**Relationships**

* One Studio → Many Content

---

## Relationship Summary

```
Studio 1 ──── * Content
Content * ──── * Genre
Content 1 ──── * Season (SERIES only)
```

---

## Required API Endpoints

### Content

```
GET    /content
GET    /content/{id}
POST   /content
PUT    /content/{id}
DELETE /content/{id}
```

---

### Seasons

```
GET  /content/{id}/seasons
POST /content/{id}/seasons
```

---

### Genres

```
GET  /genres
POST /genres
POST /content/{id}/genres/{genreId}
```

---

### Studios

```
GET  /studios
POST /studios
GET  /studios/{id}/content
```

---

## Business Rules (Service Layer)

You **must enforce the following rules in the service layer**:

* A MOVIE **cannot** have seasons
* A SERIES **can** have multiple seasons
* Season numbers must be unique per TV show
* Content **must belong to exactly one Studio**
* Content **must have at least one Genre**
* A Studio **cannot be deleted** if it has associated content

Violations should result in clear and meaningful error messages.

---

## Project Structure (Required)

```
I like to sort by domain, with related controller, entity, service and repo in each
\content
\genre
\season
\studio
```

---

## Technology Requirements

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* Postman (for testing)

---
## Example dependencies needed
```
<parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.7</version>
        <relativePath/>
    </parent>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>

        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>

        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <scope>runtime</scope>
        </dependency>
        <!-- Maven -->
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.8.14</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.mockito/mockito-core -->
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <version>5.20.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.42</version>
        </dependency>
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
            <version>3.18.0</version> <!-- upgrade to patched version -->
        </dependency>
    </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
```

