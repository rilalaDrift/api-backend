基于 React + Spring Boot + Dubbo + Gateway 的 API 接口开放调用平台。
分为 5 个子项目（核心模块），分别为：
api-backend：核心业务后端，负责用户和接口管理等核心业务功能
api-gateway：API 网关服务，负责集中的路由转发、统一鉴权、统一业务处理、访问控制等
api-common：公共模块，包括各其他模块中需要复用的方法、工具类、实体类、全局异常等
api-client-sdk：客户端 SDK，封装了对各 API 接口的调用方法，降低开发者的使用成本。
api-interface：提供模拟 API 接口
