import React, {useState} from "react";
import CreateButton from "../../UI/buttons/CreateButton/CreateButton";
import BackButton from "../../UI/buttons/BackButton/BackButton";
import {useNavigate} from "react-router-dom";
import EmployeeService from "../../../service/api/EmployeeService";
import {alertError} from "../../../utils/ExceptionUtils";

export default function CreateEmployeeForm(props) {

    const [employee, setEmployee] = useState({
        active: false,
        empRecordDigital: false,
        categoryId: 1
    })
    const navigate = useNavigate()

    function handleChange(e) {
        let {id, value} = e.target

        if (id === 'active' || id === 'empRecordDigital') {
            setEmployee(prevState => {
                return {
                    ...prevState,
                    [id]: !employee[id]
                }
            })
            return
        }

        setEmployee(prevState => {
            return {
                ...prevState,
                [id]: value
            }
        })
    }

    function save() {
        EmployeeService.addNewEmployee(employee)
            .then(() => navigate('/'))
            .catch(e => alertError(e))
    }

    return (
        <div className="container">
            <div className="row mt-5">
                <form noValidate={true}>
                    <div className="mb-3">
                        <label htmlFor="fio" className="form-label">ФИО</label>
                        <input type="text" className="form-control" id="fio" value={employee.fio}
                               onChange={(e) => handleChange(e)}/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="dateOfBirth" className="form-label">Дата рождения</label>
                        <input type="date" className="form-control" id="dateOfBirth" value={employee.dateOfBirth}
                               onChange={(e) => handleChange(e)}/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="passportSerie" className="form-label">Серия паспорта</label>
                        <input type="text" className="form-control" id="passportSerie" value={employee.passportSerie}
                               onChange={(e) => handleChange(e)}/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="passportNumber" className="form-label">Номер паспорта</label>
                        <input type="text" className="form-control" id="passportNumber" value={employee.passportNumber}
                               onChange={(e) => handleChange(e)}/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="passportGivingOrgan" className="form-label">Выдавший орган</label>
                        <input type="text" className="form-control" id="passportGivingOrgan"
                               value={employee.passportGivingOrgan}
                               onChange={(e) => handleChange(e)}/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="passportDepCode" className="form-label">Код департамента</label>
                        <input type="text" className="form-control" id="passportDepCode"
                               value={employee.passportDepCode}
                               onChange={(e) => handleChange(e)}/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="registrationAddress" className="form-label">Адрес регистрации</label>
                        <input type="text" className="form-control" id="registrationAddress"
                               value={employee.registrationAddress}
                               onChange={(e) => handleChange(e)}/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="empRecordNum" className="form-label">Номер трудовой книжки</label>
                        <input type="text" className="form-control" id="empRecordNum" value={employee.empRecordNum}
                               onChange={(e) => handleChange(e)}/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="empRecordDateStart" className="form-label">Дата начала трудовой
                            деятельности</label>
                        <input type="date" className="form-control" id="empRecordDateStart"
                               value={employee.empRecordDateStart}
                               onChange={(e) => handleChange(e)}/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="contractNumber" className="form-label">Номер контракта</label>
                        <input type="text" className="form-control" id="contractNumber" value={employee.contractNumber}
                               onChange={(e) => handleChange(e)}/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="contractDate" className="form-label">Дата начала контракта</label>
                        <input type="date" className="form-control" id="contractDate"
                               value={employee.contractDate}
                               onChange={(e) => handleChange(e)}/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="contractExpireDate" className="form-label">Дата окончания контракта</label>
                        <input type="date" className="form-control" id="contractExpireDate"
                               value={employee.contractExpireDate}
                               onChange={(e) => handleChange(e)}/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="rank" className="form-label">Учёная степень</label>
                        <input type="text" className="form-control" id="rank" value={employee.rank}
                               onChange={(e) => handleChange(e)}/>
                    </div>
                    <div className="mb-3">
                        <input type="checkbox" className="form-check-input" id="active" checked={employee.active}
                               onChange={(e) => handleChange(e)}/>
                        <label htmlFor="active" className="form-label ms-2">Работает ли сотрудник в НИУ МЭИ на текущий
                            момент</label>
                    </div>
                    <div className="mb-3">
                        <input type="checkbox" className="form-check-input" id="empRecordDigital"
                               checked={employee.empRecordDigital}
                               onChange={(e) => handleChange(e)}/>
                        <label htmlFor="empRecordDigital" className="form-label ms-2">Трудовая книжка
                            электронная</label>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="categoryId" className="form-label ms-2">Тип сотрудника</label>
                        <select id="categoryId" className="form-select"
                                value={employee.categoryId}
                                onChange={(e) => handleChange(e)}>
                            <option value={1}>Профессорско-преподавательский состав</option>
                            <option value={2}>Руководитель</option>
                            <option value={3}>Вспомогательный персонал</option>
                        </select>
                    </div>
                    <div className="mb-3">
                        <div className="me-2 d-inline-block">
                            <CreateButton btnCallback={save} className="mr-3"/>
                        </div>
                        <div className="d-inline-block">
                            <BackButton to="/"/>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    )
}