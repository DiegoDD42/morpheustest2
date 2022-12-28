import { Link } from "react-router-dom";
import "./styles.css";

const Menu = () => {
  return (
    <div className="menu">
      <header>
        <h1>Menu</h1>
      </header>
      <div className="content">
        <Link to="/listar">Listar Usuários</Link>
        <Link to="/cadastrar">Cadastrar Usuário</Link>
      </div>
    </div>
  );
};

export default Menu;
