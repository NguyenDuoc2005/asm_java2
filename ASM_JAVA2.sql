CREATE DATABASE FPL_DAOTAO
USE FPL_DAOTAO
CREATE TABLE Users(
	username nvarchar(50) primary key,
	password nvarchar(50),
	role nvarchar(50)
);

CREATE TABLE Grade (
	id int primary key identity(1,1), 
	masv nvarchar(50),
	tienganh int , 
	tinhoc int , 
	gdtc int
); 

CREATE TABLE Student(
	masv nvarchar(50) primary key,
	hoten nvarchar(50), 
	email nvarchar(50), 
	sodt nvarchar(50), 
	gioitinh bit, 
	diachi nvarchar(50), 
	hinh nvarchar(50)
);

alter table Grade
add foreign key(masv) references Student(masv) ON UPDATE CASCADE

-- thêm dữ liệu users
insert into Users values 
	('user','123','user'),
	('admin','123','admin'),
	('user2','duoc','admin')

-- bảng student 
insert into Student values 
	('ph50257',N'Nguyễn hoàng dược','duocphph50257@gmail.com','0366994505',0,'huyên ba vì thành phố hà nội','duoc.jpg'),
	('ph01',N'Nguyễn đức giang','giangphph01@gmail.com','112',1,'sơn tây','giang.jpg'),
	('ph02',N'Hứa công chính','chinhphph02@gmail.com','113',1,'hải dương','chinh.jpg'),
	('ph03',N'Phan đức hùng','hungphph03@gmail.com','115',0,'tuyên quang','hung.jpg')

-- bảng grade 
insert into	Grade values 
	('ph50257',10,10,10),
	('ph02',7,7,7),
	('ph01',9,9,9)
	
	select * from Student
	select * from Grade
	--- update student 
	update Student
	set masv= ? , hoten=? , email= ? , sodt=? ,gioitinh=? ,diachi=?,hinh= ? 
	where masv = ?	

	-- thêm sv vào grade và student 
	insert into Student values (?,?,?,?,?,?,?)
	insert into Grade (masv) values (?)
--update	

	update Student
	set masv= ? ,hoten=?,email=?,sodt =? , gioitinh=?, diachi=?,hinh=?
	where masv = ?
	
	-- bảng grade 

	-- hien thi
	select g.id, g.masv,g.tienganh,g.tinhoc,g.gdtc,st.hoten ,(g.gdtc+g.tienganh+g.tinhoc) /3.0 as 'diemTB' from Grade g 
	inner join Student st on g.masv = st.masv 

	-- thay đổi điểm 
	update Grade
	set tienganh = ? , tinhoc = ? , gdtc = ? 
	where masv = ? 
	-- tìm kiếm điểm 
	select g.id, g.masv,g.tienganh,g.tinhoc,g.gdtc,st.hoten ,(g.gdtc+g.tienganh+g.tinhoc) /3.0 as 'diemTB'from Grade  g
	inner join Student st on g.masv = st.masv
	where g.masv = ?
	-- xóa điểm -- update về null
	update Grade
	set tienganh = null, tinhoc= null , gdtc = null
	where masv = ? 
	-- hiển thị 3 điểm cao nhất của sv  
	select top 3 g.id, g.masv,g.tienganh,g.tinhoc,g.gdtc,st.hoten ,(g.gdtc+g.tienganh+g.tinhoc) /3.0 as 'diemTB' from Grade g 
	inner join Student st on g.masv = st.masv
	order by diemTB desc

	

	
	