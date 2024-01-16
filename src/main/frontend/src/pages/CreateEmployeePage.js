import React from "react";
import CreateEmployeeForm from "../components/forms/CreateEmployeeForm/CreateEmployeeForm";

export default function CreateEmployeePage() {

    return (
        <div className="container">
            <div className="row mt-5">
                <h1 className="display-3">Добавление нового сотрудника</h1>
            </div>
            <div className="row mt-5">
                <CreateEmployeeForm/>
            </div>
        </div>
    )
}