import React, {useEffect, useState} from "react";
import EditButton from "../components/UI/buttons/EditButton/EditButton";
import BackButton from "../components/UI/buttons/BackButton/BackButton";
import EmployeeService from "../service/api/EmployeeService";
import {alertError} from "../utils/ExceptionUtils";
import DisciplineService from "../service/api/DisciplineService";

export default function AddDisciplinePage() {

    const [employees, setEmployees] = useState([])
    const [disciplines, setDisciplines] = useState([])

    const [selectedDisciplineId, setSelectedDisciplineId] = useState()
    const [selectedEmployeeId, setSelectedEmployeeId] = useState()

    function handleSave() {
        EmployeeService.addDiscipline(selectedEmployeeId, selectedDisciplineId)
            .then(() => {
                alert('Успешно добавлено')
                refreshDisciplines()
            })
            .catch(e => alertError(e))
    }

    useEffect(() => {
        EmployeeService.getAllEmployees()
            .then(res => {
                setEmployees(res.data)
                setSelectedEmployeeId(res.data[0].id)
            })
            .catch(e => console.log(e))
    }, [])

    useEffect(() => {
        refreshDisciplines()
    }, [selectedEmployeeId])

    function handleEmployeeChange(e) {
        setSelectedEmployeeId(e.target.value)
    }

    function handleDisciplineChange(e) {
        setSelectedDisciplineId(e.target.value)
    }

    function refreshDisciplines() {
        if (selectedEmployeeId) {
            DisciplineService.getAllMissingDisciplinesForEmployee(selectedEmployeeId)
                .then(res => setDisciplines(res.data))
                .catch(e => alertError(e))
        }
    }

    return (
        <div className="container">
            <div className="row mt-5">
                <h1 className="display-3">Добавить сотруднику дисциплину</h1>
            </div>
            <div className="mb-3">
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
                <label htmlFor="disciplineId" className="form-label ms-2">Дисциплина</label>
                <select id="disciplineId" className="form-select"
                        value={selectedDisciplineId}
                        onChange={(e) => handleDisciplineChange(e)}>
                    {
                        disciplines.map(discipline => {
                            return <option value={discipline.id} key={discipline.id}>{discipline.name}</option>
                        })
                    }
                </select>
            </div>
            <div className="mb-3">
                <div className="me-2 d-inline-block">
                    <EditButton btnCallback={handleSave} className="mr-3"/>
                </div>
                <div className="d-inline-block">
                    <BackButton to="/"/>
                </div>
            </div>
        </div>
    )
}