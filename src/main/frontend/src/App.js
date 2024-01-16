import './App.css';
import {Route, Routes} from "react-router-dom";
import MainPage from "./pages/MainPage";
import EditEmployeePage from "./pages/EditEmployeePage";
import CreateEmployeePage from "./pages/CreateEmployeePage";
import AddDegreePage from "./pages/AddDegreePage";
import Navigation from "./components/UI/Navigation/Navigation";
import AgeGroupReportPage from "./pages/reports/AgeGroupReportPage";
import ContractEndingReportPage from "./pages/reports/ContractEndingReportPage";
import EmployeeDisciplinesReportPage from "./pages/reports/EmployeeDisciplinesReportPage";
import DegreeEmployeesReportPage from "./pages/reports/DegreeEmployeesReportPage";
import AddDisciplinePage from "./pages/AddDisciplinePage";
import EmployeeAwardsReportPage from "./pages/reports/EmployeeAwardsReportPage";
import ScheduleReportPage from "./pages/reports/ScheduleReportPage";
import DepartmentScheduleReportPage from "./pages/reports/DepartmentScheduleReportPage";
import EmployeeJobHistoryPage from "./pages/EmployeeJobHistoryPage";

function App() {
    return (
        <div className="App">
            <Navigation/>

            <Routes>
                <Route path="/" index element={<MainPage/>}/>
                <Route path="/employee/edit/:employeeId" element={<EditEmployeePage/>}/>
                <Route path="/employee/create" element={<CreateEmployeePage/>}/>
                <Route path="/employee/:employeeId/degree" element={<AddDegreePage/>}/>
                <Route path="/ageGroup" element={<AgeGroupReportPage/>}/>
                <Route path="/contractEnding" element={<ContractEndingReportPage/>}/>
                <Route path="/employee/:employeeId/disciplines" element={<EmployeeDisciplinesReportPage/>}/>
                <Route path="/degree" element={<DegreeEmployeesReportPage/>}/>
                <Route path="/addDiscipline" element={<AddDisciplinePage/>}/>
                <Route path="/awards" element={<EmployeeAwardsReportPage/>}/>
                <Route path="/schedule" element={<ScheduleReportPage/>}/>
                <Route path="/schedule/department" element={<DepartmentScheduleReportPage/>}/>
                <Route path="/employee/:employeeId/jobs" element={<EmployeeJobHistoryPage/>}/>
            </Routes>
        </div>
    );
}

export default App;
