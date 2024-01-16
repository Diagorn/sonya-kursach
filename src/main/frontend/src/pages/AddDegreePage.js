import React, {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import EmployeeService from "../service/api/EmployeeService";
import {alertError} from "../utils/ExceptionUtils";
import DegreeService from "../service/api/DegreeService";
import EditButton from "../components/UI/buttons/EditButton/EditButton";
import BackButton from "../components/UI/buttons/BackButton/BackButton";

export default function AddDegreePage() {

    const params = useParams()
    const [employee, setEmployee] = useState({
        degree: {id: 1}
    })
    const [degrees, setDegrees] = useState([])
    const [degree, setDegree] = useState({id: 1})

    useEffect(() => {
        const employeeId = params.employeeId

        EmployeeService.getEmployeeById(employeeId)
            .then(res => {
                setEmployee(res.data)
                if (res.data.degree) {
                    setDegree(res.data.degree)
                }
            })
            .catch((e) => alertError(e))

        DegreeService.getAllDegrees()
            .then(res => setDegrees(res.data))
            .catch(e => console.log(e))
    }, [])

    function handleDegreeChange(e) {
        let selectedDegree = degrees.find(deg => deg.id == e.target.value)
        setDegree(selectedDegree)
    }

    function handleSave() {
        EmployeeService.changeEmployeeDegree(employee.id, {id: degree.id})
            .catch(e => alertError(e))
    }

    return (
        <div className="container">
            <div className="row mt-5">
                <h1 className="display-3">Изменить образование сотрудника</h1>
            </div>
            <div className="mb-3">
                <label htmlFor="degreeId" className="form-label ms-2">Уровень образования</label>
                <select id="degreeId" className="form-select"
                        value={degree.id}
                        onChange={(e) => handleDegreeChange(e)}>
                    {
                        degrees.map(degree => {
                            return <option value={degree.id} key={degree.id}>{degree.name}</option>
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