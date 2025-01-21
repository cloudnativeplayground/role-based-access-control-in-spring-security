@echo off

:: Create directories
mkdir src\main\java\com\cloudnativeplayground\rbac\config
mkdir src\main\java\com\cloudnativeplayground\rbac\controller
mkdir src\main\java\com\cloudnativeplayground\rbac\entity
mkdir src\main\java\com\cloudnativeplayground\rbac\repository
mkdir src\main\java\com\cloudnativeplayground\rbac\service
mkdir src\main\resources
mkdir src\test\java\com\cloudnativeplayground\rbac

:: Create files
type nul > src\main\java\com\cloudnativeplayground\rbac\Application.java
type nul > src\main\java\com\cloudnativeplayground\rbac\config\SecurityConfig.java
type nul > src\main\java\com\cloudnativeplayground\rbac\controller\UserController.java
type nul > src\main\java\com\cloudnativeplayground\rbac\entity\Role.java
type nul > src\main\java\com\cloudnativeplayground\rbac\entity\User.java
type nul > src\main\java\com\cloudnativeplayground\rbac\repository\RoleRepository.java
type nul > src\main\java\com\cloudnativeplayground\rbac\repository\UserRepository.java
type nul > src\main\java\com\cloudnativeplayground\rbac\service\RoleService.java
type nul > src\main\java\com\cloudnativeplayground\rbac\service\UserService.java
type nul > src\main\resources\application.properties
type nul > src\main\resources\data.sql
type nul > src\test\java\com\cloudnativeplayground\rbac\UserControllerTest.java

echo Folder structure and files created successfully!
