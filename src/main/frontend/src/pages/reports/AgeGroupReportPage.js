import React, {useEffect, useState} from "react";
import BackButton from "../../components/UI/buttons/BackButton/BackButton";
import EmployeeService from "../../service/api/EmployeeService";
import EmployeeTable from "../../components/employee/EmployeeTable/EmployeeTable";

export default function AgeGroupReportPage() {

    const [employees, setEmployees] = useState([])
    const [selectedGroup, setSelectedGroup] = useState(1)

    useEffect(() => {
        refreshEmployees()
    }, [])

    function refreshEmployees(ageGroup) {
        EmployeeService.getEmployeesByAgeGroup(ageGroup ? ageGroup : selectedGroup)
            .then(res => setEmployees(res.data))
            .catch(e => console.log(e))
    }

    function handleSelectionChange(e) {
        setSelectedGroup(e.target.value)
        refreshEmployees(e.target.value)
    }

    return (
        <div className="container">
            <div className="row mt-5">
                <h1 className="display-3">Сотрудники по возрастным группам</h1>
            </div>
            <div className="row mb-3">
                <h3 className="display5">Выберите возрастную группу</h3>
            </div>
            <div className="row mb-3">
                <div className="form-check form-check-inline">
                    <input className="form-check-input" type="radio" name="ageGroup" id="young"
                           value={1}
                           checked={selectedGroup == 1}
                           onChange={(e) => handleSelectionChange(e)}/>
                    <label className="form-check-label" htmlFor="young">Молодые</label>
                </div>
                <div className="form-check form-check-inline">
                    <input className="form-check-input" type="radio" name="ageGroup" id="middle-age"
                           value={2}
                           checked={selectedGroup == 2}
                           onChange={(e) => handleSelectionChange(e)}
                    />
                    <label className="form-check-label" htmlFor="middle-age">Среднего возраста</label>
                </div>
                <div className="form-check form-check-inline">
                    <input className="form-check-input" type="radio" name="ageGroup" id="elder"
                           value={3}
                           checked={selectedGroup == 3}
                           onChange={(e) => handleSelectionChange(e)}
                    />
                    <label className="form-check-label" htmlFor="elder">Преклонного возраста</label>
                </div>
                <div className="form-check form-check-inline">
                    <input className="form-check-input" type="radio" name="ageGroup" id="old"
                           value={4}
                           checked={selectedGroup == 4}
                           onChange={(e) => handleSelectionChange(e)}
                    />
                    <label className="form-check-label" htmlFor="old">Пожилые</label>
                </div>
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