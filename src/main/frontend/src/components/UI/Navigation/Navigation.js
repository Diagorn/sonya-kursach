import React from "react";
import {Link} from "react-router-dom";

export default function Navigation() {

    return (
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
            <a className="navbar-brand">Отдел кадров</a>
            <button className="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"></span>
            </button>

            <div className="collapse navbar-collapse" id="navbarSupportedContent">
                <ul className="navbar-nav mr-auto">
                    <li className="nav-item active">
                        <Link to="/">
                            <span className="nav-link">Домашняя страница</span>
                        </Link>
                    </li>
                    <li className="nav-item">
                        <Link to="/addDiscipline">
                            <span className="nav-link">Добавить дисциплину</span>
                        </Link>
                    </li>
                    <li className="nav-item">
                        <Link to="/awards">
                            <span className="nav-link">Награды сотрудников</span>
                        </Link>
                    </li>
                    <li className="nav-item">
                        <Link to="/schedule">
                            <span className="nav-link">Расписание</span>
                        </Link>
                    </li>
                    <li className="nav-item">
                        <Link to="/schedule/department">
                            <span className="nav-link">Расписание кафедры</span>
                        </Link>
                    </li>
                    <li className="nav-item dropdown">
                        <a className="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                           data-bs-toggle="dropdown" aria-expanded="false">
                            Отчёты
                        </a>
                        <ul className="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <li>
                                <Link to="/ageGroup">
                                    <span className="dropdown-item">Возрастные группы</span>
                                </Link>
                            </li>
                            <li>
                                <Link to="/contractEnding">
                                    <span className="dropdown-item">Заканчивающиеся контракты</span>
                                </Link>
                            </li>
                            <li>
                                <Link to="degree">
                                    <span className="dropdown-item">Сотрудники по уровням образования</span>
                                </Link>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    )
}