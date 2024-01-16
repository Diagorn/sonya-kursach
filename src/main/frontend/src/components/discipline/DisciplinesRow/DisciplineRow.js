import React from "react";

export default function DisciplineRow(props) {

    return (
        <tr>
            <th scope="col">{props.discipline.name}</th>
            <th>{props.discipline.departmentName}</th>
            <th>{props.discipline.groupNumbers.join('; ')}</th>
            <th>{props.discipline.employeeFio}</th>
        </tr>
    )
}