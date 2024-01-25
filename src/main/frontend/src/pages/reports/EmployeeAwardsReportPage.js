import React, {useEffect, useState} from "react";
import BackButton from "../../components/UI/buttons/BackButton/BackButton";
import EmployeeService from "../../service/api/EmployeeService";
import AwardService from "../../service/api/AwardService";
import {alertError} from "../../utils/ExceptionUtils";
import AwardTable from "../../components/award/AwardTable/AwardTable";
import AddAwardForm from "../../components/forms/AddAwardForm/AddAwardForm";

export default function EmployeeAwardsReportPage() {

    const [selectedEmployeeId, setSelectedEmployeeId] = useState(0)
    const [awards, setAwards] = useState([])
    const [employees, setEmployees] = useState([])

    useEffect(() => {
        EmployeeService.getAllEmployees()
            .then(res => {
                setEmployees(res.data)
                setSelectedEmployeeId(res.data[0].id)
            })
            .catch(e => console.log(e))
    }, [])

    useEffect(() => {
        refreshAwards()
    }, [selectedEmployeeId])

    function handleEmployeeChange(e) {
        setSelectedEmployeeId(e.target.value)
    }

    function refreshAwards() {
        AwardService.getEmployeeAwards(selectedEmployeeId)
            .then(res => setAwards(res.data))
            .catch(e => alertError(e))
    }

    function onAddAward(award) {
        setAwards(prevAwards =>
            [
                ...prevAwards,
                award
            ]
        )
    }

    return (
        <div className="container">
            <div className="row mt-5">
                <h1 className="display-3">Награды сотрудников</h1>
            </div>
            <div className="row mb-3">
                <h3 className="display5">Выберите сотрудника</h3>
            </div>
            <div className="row mb-3">
                <label htmlFor="employeeId" className="form-label ms-2">Сотрудник</label>
                <select id="employeeId" className="form-select"
                        value={selectedEmployeeId}
                        onChange={(e) => handleEmployeeChange(e)}>
                    {
                        employees.map(employee => {
                            return <option value={employee.id} key={employee.id}>{employee.fio}</option>
                        })
                    }
                </select>
            </div>
            <div className="mb-3">
                <AwardTable awards={awards}/>
            </div>
            <div className="mb-3">
                <AddAwardForm
                    employeeId={selectedEmployeeId}
                    onAddAward={onAddAward}
                />
            </div>
            <div className="mb-3">
                <BackButton to="/"/>
            </div>
        </div>
    )
}