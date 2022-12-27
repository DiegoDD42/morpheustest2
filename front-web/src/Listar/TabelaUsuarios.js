const TabelaUsuarios = ({ usuarios }) => {
    return (
        <div className="tabela-usuario">
            <table>
                <tbody>
                    {usuarios.map((usuario) => (
                        <tr 
                            key={usuario.codigo}
                        >
                            <td>{usuario.nome}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}
 
export default TabelaUsuarios;