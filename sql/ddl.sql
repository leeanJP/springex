CREATE TABLE `tbl_todo` (
                            `tno` int(11) NOT NULL AUTO_INCREMENT,
                            `title` varchar(100) NOT NULL,
                            `dueDate` date NOT NULL,
                            `writer` varchar(50) NOT NULL,
                            `finished` tinyint(4) DEFAULT 0,
                            PRIMARY KEY (`tno`)
) ENGINE=InnoDB AUTO_INCREMENT=2045 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci

