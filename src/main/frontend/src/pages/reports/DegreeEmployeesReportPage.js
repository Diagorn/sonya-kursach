import React, {useEffect, useState} from "react";
import BackButton from "../../components/UI/buttons/BackButton/BackButton";
import EmployeeService from "../../service/api/EmployeeService";
import EmployeeTable from "../../components/employee/EmployeeTable/EmployeeTable";
import DegreeService from "../../service/api/DegreeService";
import {alertError} from "../../utils/ExceptionUtils";

export default function DegreeEmployeesReportPage() {

    const [employees, setEmployees] = useState([])
    const [degrees, setDegrees] = useState([])
    const [selectedDegree, setSelectedDegree] = useState(1)

    useEffect(() => {
        DegreeService.getAllDegrees()
            .then(res => setDegrees(res.data))
            .catch(e => console.log(e))
    }, [])

    useEffect(() => {
        EmployeeService.getEmployeesByDegreeId(selectedDegree)
            .then(res => setEmployees(res.data))
            .catch(e => alertError(e))
    }, [selectedDegree])

    function handleSelectionChange(e) {
        setSelectedDegree(e.target.value)
    }

    return (
        <div className="container">
            <div className="row mt-5">
                <h1 className="display-3">Сотрудники по уровням образования</h1>
            </div>
            <div className="row mb-3">
                <h3 className="display5">Выберите уровень образования</h3>
            </div>
            <div className="row mb-3">
                {
                    degrees.map(degree => {
                        return <div className="form-check form-check-inline">
                            <input className="form-check-input" type="radio" name="ageGroup" id="young"
                                   value={degree.id}
                                   checked={selectedDegree == degree.id}
                                   onChange={(e) => handleSelectionChange(e)}/>
                            <label className="form-check-label" htmlFor="young">{degree.name}</label>
                        </div>
                    })
                }
            </div>
            <div className="mb-3">
                <EmployeeTable employees={employees} showButtons={false}/>
            </div>
            <div className="mb-3">
                <BackButton to="/"/>
            </div>
        </div>
    )
}