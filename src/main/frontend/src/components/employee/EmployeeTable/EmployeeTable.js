import React from "react";
import EmployeeRow from "../EmployeeRow/EmployeeRow";

export default function EmployeeTable(props) {

    return (
        <table className="table table-striped">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">ФИО</th>
                <th scope="col">Кафедра</th>
                <th scope="col">Дата рождения</th>
                <th scope="col">Учёная степень</th>
                {props.showButtons &&
                    <th/>
                }
            </tr>
            </thead>
            <tbody>
            {
                props.employees.map(employee => {
                    return <EmployeeRow
                        employee={employee}
                        key={employee.id}
                        onDelete={props.onDelete}
                        showButtons={props.showButtons}
                    />
                })
            }
            </tbody>
        </table>
    )
}