import React from "react";
import EmployeeJobRow from "../EmployeeJobRow/EmployeeJobRow";

export default function EmployeeJobTable(props) {

    return (
        <table className="table table-striped">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Должность</th>
                <th scope="col">Дата начала</th>
                <th scope="col">Дата конца</th>
                <th scope="col">Организация</th>
                <th scope="col">Зарплата</th>
                <th scope="col">ФИО</th>
            </tr>
            </thead>
            <tbody>
            {
                props.jobs.map(job => {
                    return <EmployeeJobRow
                        job={job}
                        key={job.id}
                    />
                })
            }
            </tbody>
        </table>
    )
}