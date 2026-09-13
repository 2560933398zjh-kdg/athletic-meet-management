# athleticmeet — 运动会管理系统

基于 **Spring Boot + MyBatis + MySQL** 的运动会管理系统后端，提供运动员、比赛项目与成绩的增删改查与排名查询 API。

## 项目简介

管理运动会核心数据的三类实体：

- **运动员（Athlete）**：参赛人员信息
- **赛事（Event）**：比赛项目
- **成绩（Score）**：运动员在各项目中的成绩，可生成成绩排名（ScoreRankVO）

## 技术栈

- Java 21 + Spring Boot 4.0.5
- MyBatis（mybatis-spring-boot-starter 4.0.1）+ MySQL（sports_db 数据库）
- Lombok

## 目录结构

```
athleticmeet/
├── pom.xml
└── src/
    ├── main/
    │   ├── java/com/itheima/athleticmeet/
    │   │   ├── AthleticmeetApplication.java      # 启动类
    │   │   ├── controller/
    │   │   │   ├── AthleteController.java        # 运动员接口（/api/athletes）
    │   │   │   ├── EventController.java          # 赛事接口
    │   │   │   └── ScoreController.java          # 成绩接口
    │   │   ├── entity/                           # 实体：Athlete / Event / Score
    │   │   ├── mapper/                           # MyBatis Mapper：Athlete / Event / Score
    │   │   ├── service/                          # 业务层：AthleteService / ScoreService
    │   │   └── vo/ScoreRankVO.java               # 成绩排名视图对象
    │   └── resources/application.yml             # 数据源与 MyBatis 配置
    └── test/                                     # 单元测试（Mapper 测试等）
```

## 核心接口

| 方法 | 路径 | 说明 |
| --- | --- | --- |
| GET | `/api/athletes` | 查询全部运动员 |
| GET | `/api/athletes/{id}` | 按 ID 查询运动员 |
| POST | `/api/athletes` | 新增运动员 |
| PUT | `/api/athletes` | 修改运动员（请求体含 id） |
| DELETE | `/api/athletes/{id}` | 删除运动员 |

赛事、成绩接口结构与运动员类似（`/api/events`、`/api/scores` 等）。

## 运行方式

```bash
# 1. 创建 MySQL 数据库 sports_db 并初始化表结构
# 2. 确认 application.yml 中数据库账号密码（默认 root / 123456）
mvn spring-boot:run
```

## 备注

- `application.yml` 中 MyBatis `mapper-locations` 指向 `classpath:mapper/*.xml`，需在 resources 下放置对应 XML 映射文件（或使用注解 SQL）。
- 数据源连接默认 `localhost:3306/sports_db`，请按本地环境调整。
