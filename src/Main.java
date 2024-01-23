public class Main {
    public static void main(String[] args) {
        create database Tour;
        use Tour;

        create table CityTable( -- tên bảng thành phố
                id int not null primary key auto_increment,
                namecity varchar(50)
);

        create table TableTour( -- tên bảng tour
                id int not null primary key auto_increment,
                maloai int,
        tenloai varchar(50)
);

        create table CalendarDestination( -- bảng điểm đến du lịch
                id int not null primary key auto_increment,
                tendiemden varchar(50),
                mota varchar(100),
                giatrungbinh int,
        namecity_id int,
        foreign key (namecity_id) references CityTable(id)
);

        create table TableOfCustomerSbookingTours( -- bảng khách hàng đặt tours
                id int not null primary key auto_increment,
                name varchar(30),
                cccd varchar(30),
                namsinh date,
                thanhpho_id int,
        foreign key (thanhpho_id) references citytable(id)
);

        create table TourType( -- loại tour
                id int primary key auto_increment,
        matua int,
        loaitua_id int,
        giadiemden_id int,
        ngaybatdau date,
        ngayketthuc date,
        foreign key (giadiemden_id) references calendardestination(id)
);

        alter table tour.tourtype
        add constraint foreign key (loaitua_id) references tabletour(id);

        create table TourTheTableUnitSettings (-- Bảng hóa đơn đặt tour
                id int primary key auto_increment,
        tour_id int,
        khachhang_id int,
        trangthai varchar(50)
);

        alter table tour.TourTheTableUnitSettings
        add constraint foreign key (tour_id) references tourtype(id);
        alter table tour.TourTheTableUnitSettings
        add constraint foreign key (khachhang_id) references TableOfCustomerSbookingTours(id);


        insert into citytable values (1,"Thái Nguyên"),-- tên bảng thành phố
                (2,"Hải Phòng"),
                (3,"Quảng Ninh"),
        (4,"Tây Nguyên"),
        (5,"Hội An");

        insert into tabletour values (1 , 1, "tour đơn"),
        (2 , 2, "tour gia đình");

        insert into calendardestination values (1, "Hồ Núi Cốc", -- bảng điểm đến du lịch
        "cách thành phố Thái Nguyên thuộc tỉnh Thái Nguyên , Việt Nam.",1999000,1),
        (2, "Đảo Cát bà",
                "Quần đảo Cát Bà là một quần đảo gồm 367 đảo, trong đó có đảo Cát Bà ở phía nam vịnh Hạ Long.",4500000,2),
        (3, "Vịnh Hạ Long",
                "Thành phố được đặt theo tên của vịnh Hạ Long, là một di sản thiên nhiên nổi tiếng của Việt Nam.",3700000,3),
        (4, "Du Lịch Bản Đôn",
                "Tây Nguyên hấp dẫn du khách gần xa không chỉ nhờ sắc màu cuộc sống độc đáo của đồng bào dân tộc.",3200000,4),
        (5, "Phố Cổ Hội An",
                "Phố cổ Hội An là một đô thị cổ nằm ở hạ lưu sông Thu Bồn, thuộc vùng đồng bằng ven biển.",1900000,5);

        insert into tableofcustomersbookingtours values (1, "Nghiêm Hà Gia Hòa","09199003869",'1999-12-21', 1), -- - bảng khách hàng đặt tours
        (2, "Hồng Trịnh Thảo Nguyên","09199003869",'1999-09-21', 2),
        (3, "Đinh Thị Thanh Tâm","09199003869",'1999-06-21', 3),
        (4, "Đỗ Nguyễn Minh Thư","09199003869",'1999-08-21', 4),
        (5, "Phạm Thị Thu Thảo","09199003869",'1999-07-21', 5),
        (6, "Nguyễn Đăng Ngọc Hân","09199003869",'1999-09-21', 5),
        (7, "Nguyễn Thế Huy Hoàng","09199003869",'1999-04-21', 4),
        (8, "Thạch Gia Thục","09199003869",'1999-05-21', 3),
        (9, "Lê Thị Ngọc Yến","09199003869",'1999-02-21', 2),
        (10, "Mạch Quế Ân","09199003869",'1999-04-21', 1);
        insert into tourtype values (1, 101, 1, 1, '2024-04-23', '2024-04-25'),-- loại tour
                (2, 102, 1, 2, '2024-04-23', '2024-04-25'),
                (3, 103, 1, 3, '2024-04-23', '2024-04-25'),
        (4, 104, 2, 4, '2024-04-23', '2024-04-25'),
        (5, 105, 1, 5, '2024-04-23', '2024-04-25'),
        (6, 106, 1, 5, '2024-04-23', '2024-04-25'),
        (7, 107, 2, 4, '2024-04-23', '2024-04-25'),
        (8, 108, 1, 3, '2024-04-23', '2024-04-25'),
        (9, 109, 1, 2, '2024-04-23', '2024-04-25'),
        (10, 110, 2, 1, '2024-04-23', '2024-04-25'),
        (11, 111, 1, 1, '2024-04-23', '2024-04-25'),
        (12, 112, 2, 2, '2024-04-23', '2024-04-25'),
        (13, 113, 2, 3, '2024-04-23', '2024-04-25'),
        (14, 114, 2, 4, '2024-04-23', '2024-04-25'),
        (15, 115, 2, 5, '2024-04-23', '2024-04-25');
        insert into tourthetableunitsettings values (1, 1, 1, "đang chạy"),
        (2, 2, 2, "đang chạy"),
        (3, 2, 3, "đang chạy"),
        (4, 15, 4, "đang chạy"),
        (5, 15, 5, "đang chạy"),
        (6, 14, 6, "đang chạy"),
        (7, 13, 7, "đang chạy"),
        (8, 10, 8, "đang chạy"),
        (9, 11, 9, "đang chạy"),
        (10, 10, 10, "đang chạy");
        -- thống kê số lượng tour của các thành phố
        select calendardestination.tendiemden, count(calendardestination.tendiemden) as số_lượng
        from tourtype
        join calendardestination on tourtype.giadiemden_id = calendardestination.id
        join citytable on calendardestination.namecity_id = citytable.id group by calendardestination.tendiemden;
        -- Tính số tour có ngày bắt đầu trong tháng 4
        select count(*) as số_lượng
        from tourtype
        where ngaybatdau like '%4%' ;
        -- Tính số tour có ngày kết thúc trong tháng 4 năm 2023
        select count(*) as số_lượng
        from tourtype
        where month(ngayketthuc) between 1 and 5;

    }
}