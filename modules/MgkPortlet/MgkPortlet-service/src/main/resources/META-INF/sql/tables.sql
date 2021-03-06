create table mgk_Person (
	uuid_ VARCHAR(75) null,
	personId LONG not null primary key,
	name VARCHAR(75) null,
	family VARCHAR(75) null,
	nationalCode VARCHAR(75) null,
	email VARCHAR(75) null,
	address VARCHAR(75) null,
	image VARCHAR(75) null,
	description VARCHAR(75) null,
	phoneNumber VARCHAR(75) null,
	registerDate DATE null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);