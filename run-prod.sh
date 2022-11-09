#!/bin/bash
export DATABASE_URL="jdbc:h2:mem:pokebattle-api"
export DATABASE_USER="admin"
export DATABASE_PASSWORD="admin"
export DATABASE_DRIVER="org.h2.Driver"
export DATABASE_PLATFORM="org.hibernate.dialect.H2Dialect"
export DATABASE_DDL_MODE="update"

mvn spring-boot:run -Dspring-boot.run.profiles=prod
