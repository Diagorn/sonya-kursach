import React from "react";
import {useParams} from "react-router-dom";
import EditEmployeeForm from "../components/forms/EditEmployeeForm/EditEmployeeForm";

export default function EditEmployeePage(props) {

    let params = useParams()

    return (
        <div className="container">
            <div className="row mt-5">
                <h1 className="display-3">Изменение существующего сотрудника</h1>
            </div>
            <div className="row mt-5">
                <EditEmployeeForm employeeId={params.employeeId}/>
            </div>
        </div>
    )
}