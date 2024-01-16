import React, {useEffect, useState} from "react";
import EmployeeService from "../service/api/EmployeeService";
import EmployeeTable from "../components/employee/EmployeeTable/EmployeeTable";
import CreateButton from "../components/UI/buttons/CreateButton/CreateButton";
import {Link} from "react-router-dom";
import SearchField from "../components/UI/SearchField/SearchField";

export default function MainPage() {

    const [employees, setEmployees] = useState([])

    useEffect(() => {
        refreshEmployees()
    }, [])

    function refreshEmployees() {
        EmployeeService.getAllEmployees()
            .then(res => setEmployees(res.data))
            .catch(e => console.log(e))
    }

    function deleteEmployeeFromTable(id) {
        setEmployees(prevState => {
            return prevState.filter(emp => emp.id !== id)
        })
    }

    function searchEmployees(fio) {
        EmployeeService.getEmployeeByFio(fio)
            .then((res) => setEmployees(res.data))
            .catch(() => setEmployees([]))
    }

    return (
        <div className="container">
            <div className="row mt-5">
                <div className="d-flex justify-content-between">
                    <h1 className="display-3">Сотрудники НИУ МЭИ</h1>
                    <div className="d-inline-block my-auto">
                        <Link to={"/employee/create"}>
                            <CreateButton/>
                        </Link>
                    </div>
                </div>
            </div>
            <div className="row mt-1">
                <SearchField onChange={searchEmployees} onClear={refreshEmployees}/>
            </div>
            <div className="row mt-3">
                <EmployeeTable employees={employees} onDelete={deleteEmployeeFromTable} showButtons={true}/>
            </div>
        </div>
    )
}