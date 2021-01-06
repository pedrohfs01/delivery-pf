import './styles.css';
import { ReactComponent as Logo } from "./logo.svg"

function Navbar(){
    return(
        <nav className="main-navbar">
            <Logo></Logo>
            <a href="home" className="logo-text">Delivery PF</a>
        </nav>

    );
}

export default Navbar;