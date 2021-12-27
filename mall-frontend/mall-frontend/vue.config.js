module.exports = {
    configureWebpack: {
        devServer: {
            proxy: {
                '/api': {
                    target: 'http://localhost:8082',
                    changeOrigin: true,
                    pathRewrite: {
                        '^/api': ''
                    }
                }
            }
        }
    },
    css: {
        loaderOptions: {
            less: {
                modifyVars: {
                    'primary-color': '#33A892',
                    'link-color':'#33A892',
                    'border-radius-base':'2px',
                    'layout-header-background':'#303e51',
                    'menu-dark-submenu-bg':'#1c2532'
                },
                javascriptEnabled: true
            }
        }
    },
}
