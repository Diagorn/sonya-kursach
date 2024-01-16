import React from "react";
import DisciplineRow from "../DisciplinesRow/DisciplineRow";

export default function DisciplinesTable(props) {

    return (
        <table className="table table-striped">
            <thead>
            <tr>
                <th scope="col">Наименование</th>
                <th scope="col">Кафедра</th>
                <th scope="col">Номера групп</th>
                <th scope="col">ФИО сотрудника</th>
            </tr>
            </thead>
            <tbody>
            {
                props.disciplines.map(discipline => {
                    return <DisciplineRow
                        discipline={discipline}
                    />
                })
            }
            </tbody>
        </table>
    )
}