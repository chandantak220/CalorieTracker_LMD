USE [MASTER]
GO
CREATE DATABASE [SPRINGBOOTDB]
GO
ALTER DATABASE [SPRINGBOOTDB] SET AUTO_UPDATE_STATISTICS ON 
GO
CREATE TABLE [dbo].[s_caloryData](
	[caloryData_kid] [numeric](5, 0) IDENTITY(1,1) NOT NULL,
	[caloryData_date] [datetime] NULL,
	[caloryData_userId] [numeric](5, 0) NULL,
	[caloryData_InCalories] [decimal](10, 2) NULL,
	[caloryData_OutCalories] [decimal](10, 2) NULL,
	[caloryData_NetCalories] [decimal](10, 2) NULL
) ON [PRIMARY]
GO
CREATE TABLE [dbo].[s_data](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[calories] [int] NOT NULL,
	[carbohydrate] [numeric](19, 2) NOT NULL,
	[description] [int] NOT NULL,
	[fat] [numeric](19, 2) NOT NULL,
	[food_group] [varchar](255) NOT NULL,
	[form_file] [varbinary](max) NULL,
	[name] [varchar](255) NOT NULL,
	[protein] [numeric](19, 2) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
CREATE TABLE [dbo].[s_fooddata](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[calories] [numeric](19, 2) NOT NULL,
	[carbohydrate] [numeric](19, 2) NOT NULL,
	[description] [varchar](255) NOT NULL,
	[fat] [numeric](19, 2) NOT NULL,
	[food_group] [varchar](255) NOT NULL,
	[food_id] [int] NULL,
	[form_file] [varbinary](255) NULL,
	[name] [varchar](255) NOT NULL,
	[protein] [numeric](19, 2) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
CREATE TABLE [dbo].[s_met](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[dmet] [float] NOT NULL,
	[s_activity] [varchar](255) NOT NULL,
	[s_motion] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
CREATE TABLE [dbo].[s_userFoodData](
	[userFoodData_kid] [numeric](5, 0) IDENTITY(1,1) NOT NULL,
	[usr_userid] [numeric](5, 0) NULL,
	[usr_height] [numeric](4, 0) NULL,
	[usr_weight] [numeric](4, 0) NULL,
	[usr_age] [numeric](2, 0) NULL,
	[usr_gender] [char](2) NULL,
	[date] [datetime] NULL,
	[food_foodGroup] [varchar](max) NULL,
	[food_foodName] [varchar](max) NULL,
	[food_calories] [decimal](10, 2) NULL,
	[food_time] [char](2) NULL,
	[act_group] [varchar](max) NULL,
	[act_name] [varchar](max) NULL,
	[act_duration] [numeric](5, 0) NULL,
	[act_calories] [decimal](10, 2) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
CREATE TABLE [dbo].[s_usr](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[age] [int] NOT NULL,
	[dob] [varchar](255) NOT NULL,
	[gender] [varchar](255) NOT NULL,
	[height] [int] NOT NULL,
	[username] [varchar](255) NOT NULL,
	[weight] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UK_rrsgyuputbvboefulikovrw25] UNIQUE NONCLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO