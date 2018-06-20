<?php
$para = "to:lucasbarrosomendonca@gmail.com";
$assunto = "Teste de envio de email";
$mensagem = "Isto é um teste de envio de email através do PHP";
$cabecalho = "MIME-Version: 1.0" . "\r\n";
$cabecalho .= "Content-type: text/html; charset=ISO 8859-1" . "\r\n";
$cabecalho .= "from: prismasoftgc<prismasoftgc@gmail.com>" . "\r\n" . "Reply-to: lucasbarrosomendonca@gmail.com" . "\r\n";

mail($para, $assunto, $mensagem, $cabecalho);
echo "Email enviado com sucesso.";
?>
