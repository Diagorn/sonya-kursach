import React, {useEffect, useState} from "react";
import BackButton from "../../components/UI/buttons/BackButton/BackButton";
import EmployeeService from "../../service/api/EmployeeService";
import DisciplinesTable from "../../components/discipline/DisciplinesTable/DisciplinesTable";
import {useParams} from "react-router-dom";

export default function EmployeeDisciplinesReportPage() {

    const params = useParams()
    const [disciplines, setDisciplines] = useState([])

    useEffect(() => {
        EmployeeService.getEmployeeDisciplinesById(params.employeeId)
            .then(res => setDisciplines(res.data))
            .catch(e => console.log(e))
    }, [])

    return (
        <div className="container">
            <div className="row mt-5">
                <h1 className="display-3">Дисциплины сотрудника</h1>
            </div>
            <div className="mb-3">
                <DisciplinesTable disciplines={disciplines}/>
            </div>
            <div className="mb-3">
                <BackButton to="/"/>
            </div>
        </div>
    )
}