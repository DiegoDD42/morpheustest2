import { useState } from "react";
import "./styles.css";
import { useNavigate } from "react-router-dom";

const Cadastrar = () => {
  const navigate = useNavigate();
  const [nome, setNome] = useState("");
  const [msg, setMsg] = useState("");
  const [err, setErr] = useState("");

  const HandleSubmit = (e) => {
    e.preventDefault();

    fetch("http://localhost:8080/usuarios", {
      method: "POST",
      headers: {
        "Content-Type": "aplication/json",
      },
      body: nome,
    }).then((res) => {
      if (!res.ok) {
        setErr("Falha no cadastro");
      } else {
        setMsg("Usuário cadastrado");
        window.location.reload(false);
      }
    });
  };

  return (
    <div className="cadastrar">
      <header>
        <h1>Cadastrar Usuário</h1>
      </header>
      <div className="link-menu">
        <button onClick={() => navigate("/")}>Menu</button>
      </div>
      <div className="content">
        <form onSubmit={HandleSubmit}>
          <label>Insira o nome do usuário:</label>
          <input
            type="text"
            value={nome}
            onChange={(e) => setNome(e.target.value)}
          />
          <button>Cadastrar</button>
        </form>
        <div className="message">
          {msg && <h3 className="pos">{msg}</h3>}
          {err && <h3 className="neg">{err}</h3>}
        </div>
      </div>
    </div>
  );
};

export default Cadastrar;
