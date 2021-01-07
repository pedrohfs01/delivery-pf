import './styles.css';
import { ReactComponent as Logo } from "./logo.svg"
import { Link } from "react-router-dom"

function Navbar(){
    return(
        <nav className="main-navbar">
            <Logo></Logo>
            <Link to="/" className="logo-text">Delivery PF</Link>
        </nav>

    );
}

export default Navbar;