<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

${pageContext.request}
${pageContext.response}
${pageContext.session}
${pageContext.servletContext}
${pageContext.request.requestURI}

${pageScope.message}
${requestScope.message}
${sessionScope.message}
${applicationScope.message}
${message}

${param.fullname}, ${param['fullname'] }
${cookie.user.value}, ${cookie['user'].value}

${map.key}, ${map['key']}
${collections[3]}
${bean.property}

${string}
${fn:length(collectionOrString)}
${fn:trim(string)}
${fn:toLowerCase(string)}
${fn:toUpperCase(string)}
${fn:escapeXml(string)}
${fn:replace(content, find, replace)}

${fn:contains(string, 'VN')}
${fn:containsIgnoreCase(string, 'VN')}
${fn:endsWith(string, 'VN')}
${fn:startsWith(string, 'VN')}
${fn:indexOf(string, 'VN')}

${fn:substring(string, start, length)}
${fn:substringAfter(string, 'VN')}
${fn:substringBefore(string, 'VN')}

${fn:join(array, delimiter)}
${fn:split(string, delimiter)}
