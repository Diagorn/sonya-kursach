import React, {useEffect, useState} from "react";
import BackButton from "../../components/UI/buttons/BackButton/BackButton";
import EmployeeService from "../../service/api/EmployeeService";
import EmployeeTable from "../../components/employee/EmployeeTable/EmployeeTable";

export default function ContractEndingReportPage() {

    const [employees, setEmployees] = useState([])

    useEffect(() => {
        refreshEmployees()
    }, [])

    function refreshEmployees(ageGroup) {
        EmployeeService.getEmployeesWithEndingContract()
            .then(res => setEmployees(res.data))
            .catch(e => console.log(e))
    }

    return (
        <div className="container">
            <div className="row mt-5">
                <h1 className="display-3">Сотрудники, у которых заканчивается контракт в этом году</h1>
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